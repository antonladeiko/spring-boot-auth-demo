package com.mustgen.spring_boot_auth_demo.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class AppUserDetails implements UserDetails {

    /*
     we gonna store email over here for support semantic idea of
     spring security about try to fetch user by username,
     username can be ununique, email - should be unique for system always
    */
    private final String username;
    private final String password;
    private final List<? extends GrantedAuthority> authorities;

}
