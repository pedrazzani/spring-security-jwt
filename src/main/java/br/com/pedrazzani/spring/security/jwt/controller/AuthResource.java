package br.com.pedrazzani.spring.security.jwt.controller;

import br.com.pedrazzani.spring.security.jwt.dto.AuthRequestDto;
import br.com.pedrazzani.spring.security.jwt.dto.AuthResponseDto;
import br.com.pedrazzani.spring.security.jwt.dto.mapper.AuthResponseMapper;
import br.com.pedrazzani.spring.security.jwt.security.JwtUtils;
import br.com.pedrazzani.spring.security.jwt.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.function.Function;

@Slf4j
@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthResource {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final IUserService userService;
    private final AuthResponseMapper authResponseMapper;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    ResponseEntity<AuthResponseDto> auth(@Valid AuthRequestDto authRequestDto) {

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        return userService.findUserByUsername(authenticate.getName())
                .map(authResponseMapper::from)
                .map(setToken())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Function<AuthResponseDto, AuthResponseDto> setToken() {
        return auth -> {
            auth.setToken(jwtUtils.createToken(auth.getUsername()));
            return auth;
        };
    }

}
