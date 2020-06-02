package com.pandahune.jwttest.controller;

import com.pandahune.jwttest.config.security.JwtTokenProvider;
import com.pandahune.jwttest.domain.User;
import com.pandahune.jwttest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> user) {
        return userRepository.save(User.builder()
                .name(user.get("name"))
                .contact(user.get("contact"))
                .roles(Collections.singletonList("ROLE_USER"))
                .build()).getId();
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        User member = userRepository.findByName(user.get("name"))
                .orElseThrow(() -> new UsernameNotFoundException("가입되지않은 사용자입니다"));
        if (! user.get("contact").matches(member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getName(), member.getRoles());
    }
}
