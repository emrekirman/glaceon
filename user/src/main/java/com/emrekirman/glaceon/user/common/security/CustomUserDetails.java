package com.emrekirman.glaceon.user.common.security;

import com.emrekirman.glaceon.user.user.entity.User;

public class CustomUserDetails extends User {

    public CustomUserDetails() {
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
