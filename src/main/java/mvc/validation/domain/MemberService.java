package mvc.validation.domain;

public interface MemberService {
    Member getMember(int memberNo);

    boolean insertMember(Member member);
}
