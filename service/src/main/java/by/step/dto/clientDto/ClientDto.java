package by.step.dto.clientDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@EqualsAndHashCode
public class ClientDto implements Serializable {

    @NotBlank(message = "name can not be null or empty")
    private String name;

    @NotBlank(message = "lastName can not be null or empty")
    private String lastName;

    @NotBlank(message = "patronymic can not be null or empty")
    private String patronymic;

}
