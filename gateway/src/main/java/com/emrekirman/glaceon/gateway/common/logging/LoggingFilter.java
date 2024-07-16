package com.emrekirman.glaceon.gateway.common.logging;

import com.emrekirman.glaceon.gateway.security.SessionInformation;
import com.emrekirman.glaceon.gateway.security.model.CustomUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

public class LoggingFilter extends OncePerRequestFilter {
    private static final String USER_NAME = "user_name";
    private static final String REQUEST_URL = "request_url";
    private static final String TRANSACTION_ID = "transaction_id";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        /**
         * This transaction id will be recorded in the log record for all transactions printed from the beginning of the thread to the end.
         * In this way, we will be able to look at the logs of transaction queues.
         */
        final String thxId = UUID.randomUUID().toString();

        CustomUserDetails customUserDetails = null;
        try {
            customUserDetails = SessionInformation.getUser();
        } catch (Exception ignored) {

        }

        if (customUserDetails != null) {
            MDC.put(USER_NAME, customUserDetails.getUsername());
        }
        MDC.put(REQUEST_URL, request.getRequestURI());
        MDC.put(TRANSACTION_ID, thxId);

        filterChain.doFilter(request, response);

    }
}
