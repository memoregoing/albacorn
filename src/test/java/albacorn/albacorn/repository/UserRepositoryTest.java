package albacorn.albacorn.repository;

import albacorn.albacorn.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void userCreation() throws Exception {
        //given
        User user = new User("nakim");
        userRepository.save(user);
        //when
        User findUser = userRepository.findById(user.getId()).orElseThrow();
        //then
        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getName()).isEqualTo(user.getName());
    }

    @Test
    public void basicCRUD() throws Exception {

        User user1 = new User("nakim1");
        User user2 = new User("nakim2");
        userRepository.save(user1);
        userRepository.save(user2);

        //리스트 검증
        List<User> all = userRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long total = userRepository.count();
        assertThat(total).isEqualTo(2);

        //삭제 검증
        userRepository.delete(user1);
        userRepository.delete(user2);

        long deleteCount = userRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }
}