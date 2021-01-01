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
        Long saveId = userCommandService.register(userDto);
        User findUser = userRepository.findById(saveId).orElseThrow();
        //then
        Assertions.assertThat(findUser.getName()).isEqualTo(userDto.getName());
    }

    @Test
    public void updateUser() throws Exception {
        //given
        User user = new User("nakim");
        userRepository.save(user);
        User findUser = userRepository.findById(user.getId()).orElseThrow();
        UserCommandDto userCommandDto = new UserCommandDto("change name");
        //when
        userCommandService.update(findUser.getId(), userCommandDto);
        //then
        Assertions.assertThat(findUser.getName()).isEqualTo("change name");
    }

    @Test
    public void deleteUser() throws Exception {
        //given
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        User findUser1 = userRepository.findById(user1.getId()).orElseThrow();
        User findUser2 = userRepository.findById(user2.getId()).orElseThrow();
        User findUser3 = userRepository.findById(user3.getId()).orElseThrow();
        //when
        Assertions.assertThat(userRepository.count()).isEqualTo(3);
        userCommandService.delete(findUser1.getId());
        userCommandService.delete(findUser2.getId());
        //then
        Assertions.assertThat(userRepository.count()).isEqualTo(1);
    }
}