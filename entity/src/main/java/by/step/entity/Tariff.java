package by.step.entity;

import by.step.entity.parent.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Tariff extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private Integer minutes;

    private Integer megabytes;

    private Double price;

    //---------------------------------------------------------------------------------

    @OneToMany(mappedBy = "tariff", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneList;

}
