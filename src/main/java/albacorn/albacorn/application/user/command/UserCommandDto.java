package albacorn.albacorn.application.user.command;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCommandDto {
    private String name;

    public UserCommandDto(String name) {
        this.name = name;
    }
}
