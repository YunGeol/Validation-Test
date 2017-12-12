package mvc.validation.controller;

import mvc.validation.domain.Member;
import mvc.validation.domain.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{memberNo}")
    public Member getMember(@PathVariable int memberNo) {
        return memberService.getMember(memberNo);
    }
}
