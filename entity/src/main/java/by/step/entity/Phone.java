package by.step.entity;

import by.step.entity.parent.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Phone extends BaseEntity {

    @Column(name = "country", nullable = false, length = 4)
    private String countryCode;

    @Column(name = "operator", nullable = false, length = 2)
    private  String operatorCode;

    @Column(name = "mobile", nullable = false, length = 7)
    private String mobile;

}
