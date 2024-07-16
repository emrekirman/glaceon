package com.emrekirman.glaceon.gateway.security.jwt;

import com.emrekirman.glaceon.gateway.security.model.CustomUserDetails;
import com.emrekirman.glaceon.gateway.external.user.model.UserResponse;
import com.emrekirman.glaceon.gateway.external.user.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JwtUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponse user = userService.findByUsername(username);

        return new CustomUserDetails(user.getUsername(), user.getPassword(),
                new ArrayList<>(), user.getId());
    }
}