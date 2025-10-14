package com.jhops10.skillup.dto.user;

import com.jhops10.skillup.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank
        String name,
        @Email @NotBlank
        String email,
        @NotBlank
        @Size(min = 6, message = "A senha deve conter pelo menos 6 caracteres.")
        String password,
        @NotNull
        Role role
) {
}
