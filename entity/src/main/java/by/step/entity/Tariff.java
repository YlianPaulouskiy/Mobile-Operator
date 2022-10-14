package by.step.entity;

import by.step.entity.parent.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Tariff extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private Integer minutes;

    private Integer megabytes;

}
