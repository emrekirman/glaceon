package com.emrekirman.glaceon.gateway.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails extends User implements UserDetails {
    private Integer id;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             Integer id) {
        super(username, password, true, true, true, true, authorities);

        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}