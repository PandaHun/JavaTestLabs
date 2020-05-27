package com.jpa.jpashop.api;

import com.jpa.jpashop.domain.Member;
import com.jpa.jpashop.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /*
    Version  1
    problem1 - 단순 등록이지만 presentation 계층이 아닌 entity 계층에서 검증이 들어간다.
    problem2 - Entity의 properties를 바꾸면 api spec 자체가 바뀌게 된다
            ex) name - > userName   으로 바꾸면 client 팀에서는 api 호출이 어려워짐
     */
    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member membmer) {
        Long id = memberService.join(membmer);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse {
        private Long id;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberRequest {
        private String name;
    }

}
