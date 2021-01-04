package albacorn.albacorn;

import albacorn.albacorn.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit() {
            User user1 = createUser("username1");
            User user2 = createUser("username2");
            User user3 = createUser("username3");
            User user4 = createUser("username4");
            User user5 = createUser("username5");
            User user6 = createUser("username6");
            User user7 = createUser("username7");
            em.persist(user1);
            em.persist(user2);
            em.persist(user3);
            em.persist(user4);
            em.persist(user5);
            em.persist(user6);
            em.persist(user7);
        }

        private User createUser(String username) {
            return new User(username);
        }
    }
}
