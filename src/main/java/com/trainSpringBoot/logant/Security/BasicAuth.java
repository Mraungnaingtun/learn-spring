package com.trainSpringBoot.logant.Security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/basic-auth")
public class BasicAuth {

    @GetMapping("/test")
    public String getMethodName() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();

        return  auth.toString();
    }
}
