package com.pandahun.ibm.test.controller;

import com.pandahun.ibm.test.domain.Testing;
import com.pandahun.ibm.test.domain.TestingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final TestingRepo testingRepo;

    @GetMapping("/test")
    public @ResponseBody ResponseEntity<String> test() {
        List<Testing> t = testingRepo.findAll();
        for( Testing tmp : t) {
            System.out.println(tmp.toString());
        }
        return new ResponseEntity<String>(t.toString(), HttpStatus.OK);
    }

    @PostMapping("/join")
    public @ResponseBody ResponseEntity<String> join(@RequestBody Testing testing) {
        Testing res = testingRepo.save(testing);
        return new ResponseEntity<>(res.toString(), HttpStatus.OK);
    }

}
