package albacorn.albacorn.adapter.user.command;


import albacorn.albacorn.application.user.command.UserCommandDto;
import albacorn.albacorn.application.user.command.UserCommandService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateUserController {

    private final UserCommandService userCommandService;

    @PostMapping("/api/v1/users")
    public CreateUserResponse registerUserV1(@RequestBody @Valid CreateUserRequest request) {
        Long registerUserId = userCommandService.register(transferRequestToDto(request));
        return new CreateUserResponse(registerUserId);
    }

    @Data
    @NoArgsConstructor
    static class CreateUserRequest {
        private String name;

        public CreateUserRequest(String name) {
            this.name = name;
        }
    }

    @Data
    static class CreateUserResponse {
        private Long id;

        public CreateUserResponse(Long id) {
            this.id = id;
        }
    }

    public UserCommandDto transferRequestToDto(CreateUserRequest request) {
       return new UserCommandDto(request.getName());
    }
}
