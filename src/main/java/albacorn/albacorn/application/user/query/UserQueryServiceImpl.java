package albacorn.albacorn.application.user.query;

import albacorn.albacorn.entity.User;
import albacorn.albacorn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;

    @Autowired
    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<UserQueryDto> AllUsers(int page, int size) {
        Page<User> all = userRepository.findAll(PageRequest.of(page, size));
        return all.map(this::transferUserToDto);
    }

    @Override
    public UserQueryDto findByUserId(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않은 User ID 입니다."));
        return transferUserToDto(user);
    }

    public UserQueryDto transferUserToDto(User user) {
        return new UserQueryDto(user.getName());
    }
}
