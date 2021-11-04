package br.com.pedrazzani.spring.security.jwt.repository.imp;

import br.com.pedrazzani.spring.security.jwt.model.Role;
import br.com.pedrazzani.spring.security.jwt.model.RoleType;
import br.com.pedrazzani.spring.security.jwt.model.User;
import br.com.pedrazzani.spring.security.jwt.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public class InMemoryUserRepositoryImp implements IUserRepository {
    @Override
    public Optional<User> findUserByUsername(String username) {
        return List.of(
                User.builder()
                        .uuid(UUID.randomUUID())
                        .email("admin@admin.com")
                        .username("admin")
                        .password("$2a$12$x3AuLY1bIJJTAxD9aBpMJOlXJ0rZwmy9YbLVgQ4w5jk8G5mh0zRm6")
                        .roles(Set.of(Role.builder().id(1L).type(RoleType.ADMIN).build()))
                        .build(),
                User.builder()
                        .uuid(UUID.randomUUID())
                        .email("user@user.com")
                        .username("user")
                        .password("$2a$12$0CbS5DUokTXqjjfDB//DXeEcFbqXSxtHWqeaMppSQsjCQ6RuEbfyK")
                        .roles(Set.of(Role.builder().id(2L).type(RoleType.USER).build()))
                        .build()
        )
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}
