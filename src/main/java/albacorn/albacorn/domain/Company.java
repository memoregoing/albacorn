package albacorn.albacorn.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company {

    @Id @GeneratedValue
    @Column(name = "company_id")
    private Long    id;

    private String  name;

    @Embedded
    private Address address;

    @Enumerated(value = EnumType.STRING)
    private JobOpeningStatus jobOpeningStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "job_condition_id")
    private JobCondition jobCondition;

    public Company(String name) {
        this.name = name;
    }
}
