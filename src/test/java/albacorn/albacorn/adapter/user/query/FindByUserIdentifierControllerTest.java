package albacorn.albacorn.adapter.user.query;

import albacorn.albacorn.application.user.query.UserQueryDto;
import albacorn.albacorn.application.user.query.UserQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(FindByUserIdentifierController.class)
@AutoConfigureMockMvc
class FindByUserIdentifierControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserQueryService userQueryService;

    @Test
    public void findByUserIdentifier() throws Exception {
        //given
        UserQueryDto user = new UserQueryDto("nakim");
        //when
        when(userQueryService.findByUserId(Mockito.any(Long.class))).thenReturn(user);
        //then
        mockMvc.perform(get("/api/v1/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("Hakim")))
                .andDo(print());
    }

}