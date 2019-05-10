package mvc.validation.controller;

import mvc.validation.domain.Member;
import mvc.validation.domain.MemberService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MemberPutController {

    private MemberService memberService;

    public MemberPutController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * If you want to validate `Member` in request body, you must specify `@Valid` annotation like below.
     */
    @PutMapping("/members")
    public boolean insertMember(@RequestBody @Valid Member member) {
        return memberService.insertMember(member);
    }
}
