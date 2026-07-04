package com.mustgen.spring_boot_auth_demo.configuration;

import com.mustgen.spring_boot_auth_demo.security.AppUserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    // TODO: refactor
    public Optional<String> getCurrentAuditor() {
        var authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        return switch (authentication) {
            case Authentication auth when auth.getPrincipal() instanceof AppUserDetails userDetails ->
                    Optional.of(userDetails.getUsername());
            case null, default -> Optional.empty();
        };
    }

}
