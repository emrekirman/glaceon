package com.emrekirman.glaceon.user.user.controller;

import com.emrekirman.glaceon.user.user.model.UserRequest;
import com.emrekirman.glaceon.user.user.model.UserResponse;
import com.emrekirman.glaceon.user.user.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = userService.create(userRequest);

        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/by-username/{username}")
    public ResponseEntity<UserResponse> findByUsername(@PathVariable String username) {
        UserResponse byUserName = userService.findByUserName(username);

        return ResponseEntity.ok(byUserName);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> findByUsername(@RequestParam String username, @RequestParam String password) {
        boolean exist = userService.existByUsernameAndPassword(username, password);

        return ResponseEntity.ok(exist);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
