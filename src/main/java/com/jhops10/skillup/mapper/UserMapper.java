package com.jhops10.skillup.mapper;

import com.jhops10.skillup.dto.user.UserRequestDTO;
import com.jhops10.skillup.dto.user.UserResponseDTO;
import com.jhops10.skillup.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .role(dto.role())
                .build();
    }

    public static UserResponseDTO fromEntity(User entity) {
        return new UserResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getRole(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
