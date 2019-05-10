package mvc.validation.domain;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    public static String memberName = "Gil Dong, Hong";

    @Override
    public Member getMember(int memberNo) {
        Member member = new Member();
        member.setMemberName(this.memberName);
        member.setMemberNo(memberNo);
        return member;
    }

    @Override
    public boolean insertMember(Member member) {
        // logic ...
        return true;
    }
}
