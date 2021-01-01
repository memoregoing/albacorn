package albacorn.albacorn.application.user.command;

public interface UserCommandService {

    Long register(UserCommandDto dto);

    void update(Long id, UserCommandDto dto);
}
