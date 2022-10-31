package by.step.dto.clientDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDtoWithId extends ClientDto {

    private Long id;
    private String dateCreation;

}
