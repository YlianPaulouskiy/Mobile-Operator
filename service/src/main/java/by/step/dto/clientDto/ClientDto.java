package by.step.dto.clientDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class ClientDto implements Serializable {

    private String name;
    private String lastName;
    private String patronymic;

}
