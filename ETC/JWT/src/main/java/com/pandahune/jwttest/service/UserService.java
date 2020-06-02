package com.pandahune.jwttest.service;

import com.pandahune.jwttest.domain.User;
import com.pandahune.jwttest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User loadUserByUsername(String name) {
        return userRepository.findByName(name)
                .orElse(null);
    }
}
