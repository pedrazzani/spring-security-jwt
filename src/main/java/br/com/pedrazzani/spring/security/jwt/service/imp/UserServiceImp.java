package br.com.pedrazzani.spring.security.jwt.service.imp;


import br.com.pedrazzani.spring.security.jwt.model.User;
import br.com.pedrazzani.spring.security.jwt.repository.IUserRepository;
import br.com.pedrazzani.spring.security.jwt.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements IUserService {

    private final IUserRepository userRepository;

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

}
