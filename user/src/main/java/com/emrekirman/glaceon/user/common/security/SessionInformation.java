package com.emrekirman.glaceon.user.common.security;

import com.emrekirman.glaceon.user.common.exception.CustomRuntimeException;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionInformation {
    public static CustomUserDetails getUser() {
        try {
            return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new CustomRuntimeException("Session information not found");
        }
    }
}