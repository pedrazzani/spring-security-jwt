package br.com.pedrazzani.spring.security.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
public class AdminRoleResource {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    String admin() {
        return "admin has permission";
    }

}
