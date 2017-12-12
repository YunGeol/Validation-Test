package mvc.validation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Member {
    private int memberNo;
    private String memberName;
}
