package albacorn.albacorn.application.user.query;

import albacorn.albacorn.entity.User;
import albacorn.albacorn.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.hibernate.annotations.NaturalId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserQueryServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserQueryService userQueryService;

    @BeforeEach
    public void setup() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        User user4 = new User("user4");
        User user5 = new User("user5");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
    }

    @Test
    public void AllUser() throws Exception {
        //when
        List<UserQueryDto> all = userQueryService.All();
        //then
        assertThat(all.size()).isEqualTo(5);
    }

    @Test
    public void findByUserId() throws Exception {
        //when
        UserQueryDto findUser1 = userQueryService.findByUserId(1L);
        //then
        assertThat(findUser1.getName()).isEqualTo("user1");

        assertThrows(IllegalStateException.class, () -> userQueryService.findByUserId(0L));
    }
}