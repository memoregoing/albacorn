package albacorn.albacorn.application.user.command;

import albacorn.albacorn.entity.User;
import albacorn.albacorn.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Transactional
class UserCommandServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCommandService userCommandService;

    @Test
    public void registerUser() throws Exception {
        //given
        UserCommandDto userDto = new UserCommandDto("user");
        //when
        Long saveId = userCommandService.registerUser(userDto);
        User findUser = userRepository.findById(saveId).orElseThrow();
        //then
        Assertions.assertThat(findUser.getName()).isEqualTo(userDto.getName());
    }

}