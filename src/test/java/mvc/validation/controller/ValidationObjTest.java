package mvc.validation.controller;

import lombok.extern.slf4j.Slf4j;
import mvc.validation.domain.MemberServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest({MemberPutController.class, MemberServiceImpl.class})
public class ValidationObjTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void validation_test_about_normal_member_object() throws Exception {
        mvc.perform(put("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"memberNo\": 111, \"memberName\": \"Lee,YunGeol\"}")
        );
    }

    @Test
    public void validation_test_about_abnormal_memberName_object() throws Exception {
        mvc.perform(put("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"memberNo\": 111, \"memberName\": \"Lee,Yun!@#Geol\"}")
        ).andExpect(status().is4xxClientError())
        ;
    }

    @Test
    public void validation_test_about_abnormal_memberNo_object() throws Exception {
        mvc.perform(put("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"memberNo\": 9999, \"memberName\": \"Lee-YunGeol\"}")
        ).andExpect(status().is4xxClientError())
        ;
    }
}
