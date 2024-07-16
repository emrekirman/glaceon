package com.emrekirman.glaceon.gateway.security;

import com.emrekirman.glaceon.gateway.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.gateway.security.model.CustomUserDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Base64;

public class SessionInformation {
    public static CustomUserDetails getUser() {
        try {
            return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new CustomRuntimeException("Session information not found");
        }
    }

    public static String getBase64() {
        CustomUserDetails user = SessionInformation.getUser();

        ObjectMapper objectMapper = new ObjectMapper();
        String value = null;
        try {
            value = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new CustomRuntimeException("Token not encoded");
        }

        return Base64.getEncoder().encodeToString(value.getBytes());
    }
}