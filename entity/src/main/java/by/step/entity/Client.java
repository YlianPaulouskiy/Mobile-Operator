package by.step.entity;

import by.step.entity.parent.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Client extends BaseEntity {

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "patronymic", nullable = false, length = 40)
    private String patronymic;

    //---------------------------------------------------------------------------------

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneList;

}
