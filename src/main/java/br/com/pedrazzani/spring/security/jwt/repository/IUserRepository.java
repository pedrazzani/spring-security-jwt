package br.com.pedrazzani.spring.security.jwt.repository;

import br.com.pedrazzani.spring.security.jwt.model.User;

import java.util.Optional;

public interface IUserRepository {

    public Optional<User> findUserByUsername(String username);
}
