package by.step.entity.parent;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    private Date dateCreation;

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;

    @Version
    @Column(name = "version")
    private Long version;

}
