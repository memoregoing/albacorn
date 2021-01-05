package albacorn.albacorn.adapter.user.query;

import albacorn.albacorn.application.user.query.UserQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(AllUserController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class AllUserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserQueryService userQueryService;

    @Test
    public void allUserTest() throws Exception {
        //given
        //when
        mockMvc.perform(get("/api/v1/users?page=0&size=3")).andExpect(status().isOk());
        //then
        verify(userQueryService).AllUsers(any(int.class), any(int.class));
    }
}