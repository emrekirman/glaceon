package com.emrekirman.glaceon.user.user.service.impl;

import com.emrekirman.glaceon.user.common.entity.BaseEntity;
import com.emrekirman.glaceon.user.common.exception.CustomNotFoundException;
import com.emrekirman.glaceon.user.user.entity.User;
import com.emrekirman.glaceon.user.user.mapper.UserMapper;
import com.emrekirman.glaceon.user.user.model.UserRequest;
import com.emrekirman.glaceon.user.user.model.UserResponse;
import com.emrekirman.glaceon.user.user.repository.UserRepository;
import com.emrekirman.glaceon.user.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserCheckMandatoryService userCheckMandatoryService;

    @Override
    public UserResponse create(UserRequest userRequest) {

        log.info("user create request, request : {}", userRequest);

        userCheckMandatoryService.createCheckManda(userRequest);

        User user = userMapper.mapRequestToEntity(userRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        BaseEntity.setCreateAudit(user);

        User saved = userRepository.save(user);

        log.info("user inserted to db. id : {} , username : {}", saved.getId(), saved.getUsername());

        return userMapper.mapEntityToResponse(saved);
    }

    @Override
    public UserResponse findByUserName(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomNotFoundException("user.not.found"));
        return userMapper.mapEntityToResponse(user);
    }

    @Override
    public boolean existByUsernameAndPassword(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    @Override
    public UserResponse findById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomNotFoundException("user.not.found"));

        return userMapper.mapEntityToResponse(user);
    }
}
