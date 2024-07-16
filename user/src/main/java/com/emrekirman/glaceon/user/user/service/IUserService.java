package com.emrekirman.glaceon.user.user.service;

import com.emrekirman.glaceon.user.user.model.UserRequest;
import com.emrekirman.glaceon.user.user.model.UserResponse;

public interface IUserService {
    UserResponse create(UserRequest userRequest);

    UserResponse findByUserName(String username);

    boolean existByUsernameAndPassword(String username, String password);

    UserResponse findById(Integer id);
}
