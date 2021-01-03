package albacorn.albacorn.adapter.user.command;

import albacorn.albacorn.application.user.command.UserCommandDto;
import albacorn.albacorn.application.user.command.UserCommandService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.security.auth.login.CredentialException;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(CreateUserController.class)
class CreateUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserCommandService userCommandService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void registerUserController() throws Exception {
        //give
        String content = asJsonString(new CreateUserController.CreateUserRequest("Hakim"));
        when(userCommandService.register(any(UserCommandDto.class))).thenReturn(2L);
        mockMvc.perform(post("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}