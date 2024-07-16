package com.emrekirman.glaceon.gateway.auth.service;

import com.emrekirman.glaceon.gateway.auth.model.LoginRequest;
import com.emrekirman.glaceon.gateway.common.exception.CustomAuthorizationException;
import com.emrekirman.glaceon.gateway.common.model.LoginResponse;
import com.emrekirman.glaceon.gateway.security.jwt.JwtTokenUtil;
import com.emrekirman.glaceon.gateway.security.jwt.JwtUserDetailService;
import com.emrekirman.glaceon.gateway.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager manager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailService jwtUserDetailService;


    public LoginResponse auth(LoginRequest requestDto) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));
        } catch (Exception e) {
            throw new CustomAuthorizationException("username.password.wrong");
        }

        CustomUserDetails customUserDetails = jwtUserDetailService.loadUserByUsername(requestDto.getUsername());

        return new LoginResponse(jwtTokenUtil.generateToken(customUserDetails).getToken());
    }
}