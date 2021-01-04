package albacorn.albacorn.adapter.user.command;

import albacorn.albacorn.application.user.command.UserCommandDto;
import albacorn.albacorn.application.user.command.UserCommandService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UpdateUserController {

    private final UserCommandService userCommandService;

    @PutMapping("/api/v1/users/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody @Valid UpdateUserRequest request) {
        userCommandService.update(id, transferRequestToDto(request));
    }

    @Data
    @NoArgsConstructor
    static class UpdateUserRequest {
        private String name;

        public UpdateUserRequest(String name) {
            this.name = name;
        }
    }

    public UserCommandDto transferRequestToDto(UpdateUserRequest request) {
        return new UserCommandDto(request.getName());
    }
}
