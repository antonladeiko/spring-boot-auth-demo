package com.mustgen.spring_boot_auth_demo.service;

import com.mustgen.spring_boot_auth_demo.model.entity.User;

public interface UserService {

    boolean isUserExist(String email);

    User save(User user);

}
