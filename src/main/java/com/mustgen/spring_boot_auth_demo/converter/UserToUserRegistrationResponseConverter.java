package com.mustgen.spring_boot_auth_demo.converter;

import com.mustgen.spring_boot_auth_demo.model.dto.response.RegistrationUserResponseDto;
import com.mustgen.spring_boot_auth_demo.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserRegistrationResponseConverter implements BaseConverter<User, RegistrationUserResponseDto> {

    @Override
    public RegistrationUserResponseDto convert(User source) {
        return new RegistrationUserResponseDto(
            source.getId(),
            source.getEmail()
        );
    }

}
