package com.jhops10.skillup.controller;

import com.jhops10.skillup.dto.user.UserRequestDTO;
import com.jhops10.skillup.dto.user.UserResponseDTO;
import com.jhops10.skillup.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {
        UserResponseDTO createdUser = userService.create(dto);
        URI location = URI.create("/api/v1/users/" + createdUser.id());
        return ResponseEntity.created(location).body(createdUser);
    }
}
