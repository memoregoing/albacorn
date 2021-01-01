package albacorn.albacorn.application.user.command;

import albacorn.albacorn.entity.User;
import albacorn.albacorn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long register(UserCommandDto dto) {
        User user = new User(dto.getName());
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public void update(Long id, UserCommandDto dto) {
        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        user.update(transferDtoToUser(dto));
    }

    public User transferDtoToUser(UserCommandDto dto) {
        return new User(dto.getName());
    }
}
