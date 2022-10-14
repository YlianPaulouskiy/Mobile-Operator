package by.step.dto.parent;

import lombok.Data;

@Data
public abstract class BaseDto {

    private Long id;

    private String dateCreation;

    private String lastModified;

    private Long version;

}
