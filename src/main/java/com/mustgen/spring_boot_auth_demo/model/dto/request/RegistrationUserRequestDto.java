package com.mustgen.spring_boot_auth_demo.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegistrationUserRequestDto(
    @NotBlank String username,
    @NotBlank String email,
    @NotBlank String password,
    @NotBlank String role
) {
}
