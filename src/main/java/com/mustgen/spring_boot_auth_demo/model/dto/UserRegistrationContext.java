package com.mustgen.spring_boot_auth_demo.model.dto;

import com.mustgen.spring_boot_auth_demo.model.entity.Role;

public record UserRegistrationContext(
    String passwordHash,
    Role role
) {
}
