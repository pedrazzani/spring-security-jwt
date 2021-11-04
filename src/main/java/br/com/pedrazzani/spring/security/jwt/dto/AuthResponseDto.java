package br.com.pedrazzani.spring.security.jwt.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuthResponseDto {

    private UUID uuid;
    private String username;
    private String email;
    private String token;
    private final String type = "Bearer";

}
