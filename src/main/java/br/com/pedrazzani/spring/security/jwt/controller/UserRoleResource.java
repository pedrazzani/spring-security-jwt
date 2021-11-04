package br.com.pedrazzani.spring.security.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserRoleResource {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    String user() {
        return "user has permission";
    }

}
