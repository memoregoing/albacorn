package albacorn.albacorn.adapter.user.query;

import albacorn.albacorn.application.user.query.UserQueryDto;
import albacorn.albacorn.application.user.query.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AllUserController {

    private final UserQueryService userQueryService;

    @GetMapping("/api/v1/users")
    public Page<UserQueryDto> findAllUsers(@Param("page") int page, @Param("size") int size) {
        return userQueryService.AllUsers(page, size);
    }
}
