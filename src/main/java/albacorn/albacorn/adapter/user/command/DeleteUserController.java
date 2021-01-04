package albacorn.albacorn.adapter.user.command;


import albacorn.albacorn.application.user.command.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteUserController {

    private final UserCommandService userCommandService;

    @DeleteMapping("/api/v1/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userCommandService.delete(id);
    }
}
