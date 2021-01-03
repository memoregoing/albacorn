package albacorn.albacorn.adapter.user.command;

import albacorn.albacorn.application.user.command.UserCommandDto;
import albacorn.albacorn.application.user.command.UserCommandService;
import albacorn.albacorn.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static albacorn.albacorn.adapter.user.command.UpdateUserController.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(UpdateUserController.class)
class UpdateUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    UserCommandService userCommandService;

    @Test
    public void updateUser() throws Exception {
        //given
        UpdateUserRequest requestDto = new UpdateUserRequest("Hakim");
        String content = asJsonString(requestDto);
        //when
        mockMvc.perform(put("/api/v1/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andDo(print());
        //then
        doAnswer(invocation -> {
            Long id = invocation.getArgument(0);
            UserCommandDto dto = invocation.getArgument(1);
            assertEquals(id, 1L);
            assertEquals(dto.getName(), requestDto.getName());
            return null;
        }).when(userCommandService).update(any(Long.class), any(UserCommandDto.class));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}