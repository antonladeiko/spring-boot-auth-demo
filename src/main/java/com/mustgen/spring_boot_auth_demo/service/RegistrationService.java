package com.mustgen.spring_boot_auth_demo.service;

import com.mustgen.spring_boot_auth_demo.model.dto.request.RegistrationUserRequestDto;
import com.mustgen.spring_boot_auth_demo.model.dto.response.RegistrationUserResponseDto;

public interface RegistrationService {

    RegistrationUserResponseDto register(RegistrationUserRequestDto request);

}
