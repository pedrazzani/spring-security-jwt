package br.com.pedrazzani.spring.security.jwt.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class User {
    @ToString.Exclude
    private Long id;
    private UUID uuid;
    private String username;
    @ToString.Exclude
    private String password;
    private String email;
    private Set<Role> roles;
}
