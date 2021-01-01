package albacorn.albacorn.application.user.query;


import java.util.List;

public interface UserQueryService {

    List<UserQueryDto> All();

    UserQueryDto findByUserId(Long id);
}
