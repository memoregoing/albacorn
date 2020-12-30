package albacorn.albacorn.domain;

import javax.persistence.*;

@Entity
public class JobPost {

    @Id @GeneratedValue
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

}
