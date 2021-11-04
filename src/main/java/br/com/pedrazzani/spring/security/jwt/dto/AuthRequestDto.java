package br.com.pedrazzani.spring.security.jwt.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthRequestDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

}
