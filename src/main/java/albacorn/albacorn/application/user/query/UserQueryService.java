package albacorn.albacorn.application.user.query;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserQueryService {

    @Query(countQuery = "select count(u) from User u")
    Page<UserQueryDto> AllUsers(int page, int size);

    UserQueryDto findByUserId(Long id);
}
