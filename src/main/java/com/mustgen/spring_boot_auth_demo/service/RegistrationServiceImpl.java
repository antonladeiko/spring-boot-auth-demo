package com.mustgen.spring_boot_auth_demo.service;

import com.mustgen.spring_boot_auth_demo.converter.RegistrationUserRequestToUserEntityConverter;
import com.mustgen.spring_boot_auth_demo.converter.UserToUserRegistrationResponseConverter;
import com.mustgen.spring_boot_auth_demo.model.dto.UserRegistrationContext;
import com.mustgen.spring_boot_auth_demo.model.dto.request.RegistrationUserRequestDto;
import com.mustgen.spring_boot_auth_demo.model.dto.response.RegistrationUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserToUserRegistrationResponseConverter toResponseConverter;
    private final RegistrationUserRequestToUserEntityConverter toUserEntityConverter;

    @Override
    public RegistrationUserResponseDto register(RegistrationUserRequestDto request) {
        if (userService.isUserExist(request.email())) {
            throw new RuntimeException(String.format("User with email: %s is already exist", request.email()));
        }

        var role = roleService.getByName(request.role());
        var passwordHash = passwordEncoder.encode(request.password());
        var registrationContext = new UserRegistrationContext(passwordHash, role);
        var user = userService.save(toUserEntityConverter.convert(request, registrationContext));

        return toResponseConverter.convert(user);
    }

}
