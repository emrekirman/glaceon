package com.emrekirman.glaceon.gateway.external.user.service;

import com.emrekirman.glaceon.gateway.external.user.model.UserRequest;
import com.emrekirman.glaceon.gateway.external.user.model.UserResponse;

public interface IUserService {
    UserResponse findByUsername(String username);

    UserResponse create(UserRequest userRequest);
}
