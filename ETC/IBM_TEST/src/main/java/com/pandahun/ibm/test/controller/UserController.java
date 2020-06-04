package com.pandahun.ibm.test.controller;

import com.pandahun.ibm.test.domain.User;
import com.pandahun.ibm.test.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @RequestMapping("/test")
    public @ResponseBody ResponseEntity<String> test() {
        List<String> list = new ArrayList<>();
        list.add("User is a");
        for(User user : userRepository.findAll()) {
            list.add(user.toString());
        }
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }

}
