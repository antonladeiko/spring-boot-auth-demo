package com.mustgen.spring_boot_auth_demo.controller.common;

import com.mustgen.spring_boot_auth_demo.model.dto.request.RegistrationUserRequestDto;
import com.mustgen.spring_boot_auth_demo.model.dto.response.RegistrationUserResponseDto;
import com.mustgen.spring_boot_auth_demo.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationUserResponseDto> register(
        @RequestBody @Valid RegistrationUserRequestDto request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registrationService.register(request));
    }

}
