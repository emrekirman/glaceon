package com.emrekirman.glaceon.user.user.service.impl;

import com.emrekirman.glaceon.user.common.exception.CustomRuntimeException;
import com.emrekirman.glaceon.user.user.model.UserRequest;
import com.emrekirman.glaceon.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * This class was created to increase validation and error detection capabilities in operations performed on the User.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserCheckMandatoryService {
    private final UserRepository userRepository;


    public void createCheckManda(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            log.info("username already exist. username : {}", userRequest.getUsername());
            throw new CustomRuntimeException("user.already.added");
        }
    }
}
