package com.mustgen.spring_boot_auth_demo.converter;

import com.mustgen.spring_boot_auth_demo.model.dto.UserRegistrationContext;
import com.mustgen.spring_boot_auth_demo.model.dto.request.RegistrationUserRequestDto;
import com.mustgen.spring_boot_auth_demo.model.entity.User;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class RegistrationUserRequestToUserEntityConverter
        implements BaseContextConverter<RegistrationUserRequestDto, UserRegistrationContext, User> {

    @Override
    public User convert(RegistrationUserRequestDto source, UserRegistrationContext context) {
        return new User(
            source.username(),
            source.email(),
            context.passwordHash(),
            Set.of(context.role())
        );
    }

}
