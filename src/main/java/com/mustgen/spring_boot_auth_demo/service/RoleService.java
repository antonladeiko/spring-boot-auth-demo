package com.mustgen.spring_boot_auth_demo.service;

import com.mustgen.spring_boot_auth_demo.model.entity.Role;

public interface RoleService {

    Role getByName(String name);

}
