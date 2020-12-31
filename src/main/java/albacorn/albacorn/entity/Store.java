package albacorn.albacorn.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Store {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private Address address;
}
