package mvc.validation.domain;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Data
public class Member {
    @Max(1111)
    private int memberNo;

    @Pattern(regexp = "[\\w\\s-,]+")
    private String memberName;
}
