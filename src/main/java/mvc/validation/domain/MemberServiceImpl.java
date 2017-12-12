package mvc.validation.domain;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    public static String memberName = "Gil Dong, Hong";

    @Override
    public Member getMember(int memberNo) {

        return Member.builder()
                     .memberNo(memberNo)
                     .memberName(memberName)
                     .build();
    }
}
