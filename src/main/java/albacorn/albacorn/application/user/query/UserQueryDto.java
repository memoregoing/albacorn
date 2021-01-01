package albacorn.albacorn.application.user.query;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(of = {"name"})
public class UserQueryDto {
    String name;

    public UserQueryDto(String name) {
        this.name = name;
    }
}
