package com.emrekirman.glaceon.user.common.security;

import com.emrekirman.glaceon.user.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.user.user.service.IUserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class CustomRequestFilter extends OncePerRequestFilter {
    private final IUserService userService;

    private final RequestMatcher ignoredPaths =
            new AntPathRequestMatcher("/api/v1/users/by-username/**");

    private final RequestMatcher ignoredPath2 =
            new AntPathRequestMatcher("/api/v1/users/exists");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /**
         * What I do for URLs where I don't want the filter to work:
         */
        if (this.ignoredPaths.matches(request) || this.ignoredPath2.matches(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        /**
         * We transfer the basic user information in the JWT token created in the Gateway service to the sub-microservices by converting it to base64.
         * Therefore, by easily decoding, we actually create a thread safe session.
         */
        final String requestTokenHeader = request.getHeader("api-key");


        /**
         * We convert the information coming as Base64 to the class we want.
         */
        CustomUserDetails userDetails;
        try {
            userDetails = this.getUserDetailsFromToken(requestTokenHeader);
        } catch (Exception e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token parse error");
            return;
        }

        /**
         * Then I verify the username and password information.
         */
        boolean exist = userService.existByUsernameAndPassword(userDetails.getUsername(), userDetails.getPassword());

        if (!exist) throw new CustomRuntimeException("Username or password not valid");


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>());

        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);
    }

    private CustomUserDetails getUserDetailsFromToken(String header) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            /**
             * Preventing mismatched fields from giving errors
             */
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


            byte[] objectString = Base64.getDecoder().decode(header);

            return objectMapper.readValue(objectString, CustomUserDetails.class);
        } catch (Exception e) {
            throw new CustomRuntimeException("Token not parsing");
        }
    }
}
