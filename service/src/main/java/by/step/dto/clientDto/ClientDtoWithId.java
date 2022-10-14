package by.step.dto.clientDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientDtoWithId extends ClientDto {

    private Long id;

    private String dateCreation;

    private String lastModified;

    private Long version;

}
