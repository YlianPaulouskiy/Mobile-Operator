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

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "last_name", length = 25)
    private String lastName;

    @Column(nullable = false)
    private String patronymic;

    //---------------------------------------------------------------------------------

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phoneList;

}
