package com.pandahune.jwttest.controller;

import com.pandahune.jwttest.config.security.JwtTokenProvider;
import com.pandahune.jwttest.domain.User;
import com.pandahune.jwttest.domain.result.CommonResult;
import com.pandahune.jwttest.domain.result.SingleResult;
import com.pandahune.jwttest.advice.exception.CEmailSigninFailedException;
import com.pandahune.jwttest.repository.UserJpaRepo;
import com.pandahune.jwttest.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Api(tags = "signin")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class SignController {

    private final UserJpaRepo jpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private ResponseService responseService;

    @ApiOperation(value = "로그인", notes = "이름으로 로그인")
    @PostMapping("/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원 ID= 이름", required = true) @RequestParam String name,
                                       @ApiParam(value = "비밀번호= 연락처", required = true) @RequestParam String contact) {
        User user = jpaRepo.findByName(name).orElseThrow(CEmailSigninFailedException::new);
        if (!contact.matches(user.getContact())) {
            throw new CEmailSigninFailedException();
        }
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles()));
    }

    @ApiOperation(value = "가입", notes ="회원가입을 한다")
    @PostMapping("/signup")
    public CommonResult signup(@ApiParam(value = "회원 ID= 이름", required = true) @RequestParam String name,
                               @ApiParam(value = "비밀번호= 연락처", required = true) @RequestParam String contact) {
        jpaRepo.save(User.builder()
                .name(name)
                .contact(contact)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }
}
