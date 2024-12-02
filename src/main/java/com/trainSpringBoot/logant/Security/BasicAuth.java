package com.trainSpringBoot.logant.Security;

import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basic-auth")
public class BasicAuth {

    @GetMapping("/test")
    public ResponseEntity<?> getMethodName() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();
        Object principal = auth.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "username", username,
                "principal", principal,
                "authorities", authorities));
    }

}
