package br.com.pedrazzani.spring.security.jwt.security;

import br.com.pedrazzani.spring.security.jwt.exception.UserNotFoundException;
import br.com.pedrazzani.spring.security.jwt.model.Role;
import br.com.pedrazzani.spring.security.jwt.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {

    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userService.findUserByUsername(username)
                .map(user -> User
                        .withUsername(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRoles().stream().map(Role::getAuthority).collect(Collectors.toSet()).toArray(new String[0]))
                        .build())
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }
}
