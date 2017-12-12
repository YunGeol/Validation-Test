package mvc.validation.controller;

import mvc.validation.domain.MemberServiceImpl;
import org.junit.Test;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;

public class MemberControllerTest {
    // /members/{memberNo}/addresses?limit=숫자&encryption=true/false

    @Test
    public void get_member_info_test() {

        int memberNo = 12345;

        given()
            .standaloneSetup(
                new MemberController(
                    new MemberServiceImpl()
                )
            )
        .when()
            .get("/members/" + memberNo)
        .then()
            .statusCode(200)
            .body("memberNo", equalTo(memberNo))
            .body("memberName", equalTo(MemberServiceImpl.memberName))
        ;
    }

}

