package com.mustgen.spring_boot_auth_demo.service;

import com.mustgen.spring_boot_auth_demo.model.dto.request.RegistrationUserRequestDto;
import com.mustgen.spring_boot_auth_demo.model.dto.response.RegistrationUserResponseDto;
import com.mustgen.spring_boot_auth_demo.model.entity.Role;
import com.mustgen.spring_boot_auth_demo.model.entity.User;
import com.mustgen.spring_boot_auth_demo.repository.RoleRepository;
import com.mustgen.spring_boot_auth_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Set;

// TODO: refactor
@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RegistrationUserResponseDto register(RegistrationUserRequestDto request) {
        var userEmail = request.email();
        var user = userRepository.findByEmail(userEmail);
        if (user.isPresent()) {
            throw new RuntimeException(String.format("User with email: %s is already exist", userEmail));
        }

        var role = roleRepository.findByName(request.role())
                .orElseThrow(
                    () -> new RuntimeException(String.format("Role: %s is doesn't exist", request.role()))
                );

        var newUser = userRepository.save(prepareNewUser(request, role));

        return new RegistrationUserResponseDto(
            newUser.getId(),
            newUser.getEmail()
        );
    }

    private User prepareNewUser(RegistrationUserRequestDto request, Role role) {
        return new User(
            request.username(),
            request.email(),
            passwordEncoder.encode(request.password()),
            Set.of(role)
        );
    }

}
