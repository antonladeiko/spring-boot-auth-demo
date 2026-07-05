package com.mustgen.spring_boot_auth_demo.service;

import com.mustgen.spring_boot_auth_demo.model.entity.Role;
import com.mustgen.spring_boot_auth_demo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name)
            .orElseThrow(
                () -> new RuntimeException(String.format("Role: %s is doesn't exist", name))
            );
    }

}
