package mvc.validation.controller;

import lombok.extern.slf4j.Slf4j;
import mvc.validation.domain.MemberServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest({MemberController.class, MemberServiceImpl.class})
public class ValidationTest {
    @Autowired
    private MockMvc mvc;

    /**
     * This testcase can check validation
     */
    @Test(expected = NestedServletException.class)
    public void validation_test() throws Exception {
        mvc.perform(get("/members/11111"));
    }
}
