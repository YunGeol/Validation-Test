package mvc.validation.controller;

import mvc.validation.domain.Member;
import mvc.validation.domain.MemberService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;

/**
 * If you want to use @Max annotation at request parameter validation, you should use @Validated at class level.
 */
@Validated
@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{memberNo}")
    public Member getMember(@PathVariable @Max(1111) int memberNo) {
        return memberService.getMember(memberNo);
    }
}
