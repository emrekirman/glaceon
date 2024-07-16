package com.emrekirman.glaceon.inventory.common.security;

import com.emrekirman.glaceon.inventory.external.user.UserService;
import com.emrekirman.glaceon.inventory.common.exception.CustomRuntimeException;
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
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class CustomRequestFilter extends OncePerRequestFilter {
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("api-key");


        CustomUserDetails userDetails;
        try {
            userDetails = this.getUserDetailsFromToken(requestTokenHeader);
        } catch (Exception e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token parse error");
            return;
        }

        boolean exist = userService.existUsernameAndPassword(userDetails.getUsername(), userDetails.getPassword());

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
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


            byte[] objectString = Base64.getDecoder().decode(header);

            return objectMapper.readValue(objectString, CustomUserDetails.class);
        } catch (Exception e) {
            throw new CustomRuntimeException("Token not parsing");
        }
    }
}
