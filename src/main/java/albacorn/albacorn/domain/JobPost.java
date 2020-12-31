package albacorn.albacorn.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class JobPost {

    @Id @GeneratedValue
    @Column(name = "job_post_id")
    private Long    id;

    private String  title;

    @Enumerated(value = EnumType.STRING)
    private ShiftPattern shiftPattern;

    private int hourlyWage;

    private int officeHour;

    private String  url;

    @Enumerated(value = EnumType.STRING)
    private JobOpeningStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_condition_id")
    private JobCondition jobCondition;

    public JobPost(String title) {
        this.title = title;
    }
}
