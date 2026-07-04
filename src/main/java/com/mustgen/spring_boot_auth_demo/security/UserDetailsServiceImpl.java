package com.mustgen.spring_boot_auth_demo.security;

import com.mustgen.spring_boot_auth_demo.model.entity.Role;
import com.mustgen.spring_boot_auth_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(@NonNull String email) {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                    String.format("User with email: %s doesn't exist", email))
                );
        var authorities = user.getRoles()
                .stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .toList();

        return new AppUserDetails(
            user.getEmail(),
            user.getPasswordHash(),
            authorities
        );
    }

}
