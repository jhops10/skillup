package com.jhops10.skillup.service;

import com.jhops10.skillup.dto.user.UserRequestDTO;
import com.jhops10.skillup.dto.user.UserResponseDTO;
import com.jhops10.skillup.exception.EmailAlreadyExistsException;
import com.jhops10.skillup.mapper.UserMapper;
import com.jhops10.skillup.model.User;
import com.jhops10.skillup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public UserResponseDTO create(UserRequestDTO dto) {
        Optional<User> existingUser = userRepository.findByEmail(dto.email());

        if (existingUser.isPresent()) {
            throw new EmailAlreadyExistsException("Erro! Email já cadastrado.");
        }

        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        user = userRepository.save(user);
        return UserMapper.fromEntity(user);

    }
}
