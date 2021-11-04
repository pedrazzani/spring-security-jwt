package br.com.pedrazzani.spring.security.jwt.service;

import br.com.pedrazzani.spring.security.jwt.model.User;

import java.util.Optional;

public interface IUserService {

    public Optional<User> findUserByUsername(String username);
}
