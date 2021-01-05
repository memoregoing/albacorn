package albacorn.albacorn.adapter.user.query;

import albacorn.albacorn.application.user.query.UserQueryDto;
import albacorn.albacorn.application.user.query.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindByUserIdentifierController {

    private final UserQueryService userQueryService;

    @GetMapping("/api/v1/users/{userId}")
    public UserQueryDto findByUserIdentifier(@PathVariable("userId") Long userId) {
        return userQueryService.findByUserId(userId);
    }
}
