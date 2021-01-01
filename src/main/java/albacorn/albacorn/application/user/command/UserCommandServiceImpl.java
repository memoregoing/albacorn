package albacorn.albacorn.application.user.command;

import albacorn.albacorn.entity.User;
import albacorn.albacorn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long registerUser(UserCommandDto dto) {
        User user = new User(dto.getName());
        userRepository.save(user);
        return user.getId();
    }
}
