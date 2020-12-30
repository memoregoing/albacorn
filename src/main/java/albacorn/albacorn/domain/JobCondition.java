package albacorn.albacorn.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class JobCondition {

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long id;

    @OneToOne(mappedBy = "jobCondition", fetch = FetchType.LAZY)
    private Company company;

    private Long activatedCount;
    private Long deactivatedCount;

    @OneToMany(mappedBy = "jobCondition")
    private List<JobPost> jobPosts = new ArrayList<>();

}
