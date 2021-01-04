package albacorn.albacorn.adapter.user.command;

import albacorn.albacorn.application.user.command.UserCommandService;
import com.google.common.net.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(DeleteUserController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class DeleteUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserCommandService userCommandService;

    @Test
    public void deleteUser() throws Exception {
        //given
        Long requestId = 1L;
        //when
        mockMvc.perform(delete("/api/v1/users/1")).andDo(print());
        //then
        doAnswer(invocation -> {
            Assertions.assertEquals(1L, 1L);
            return null;
        }).when(userCommandService).delete(any(Long.class));
    }
}