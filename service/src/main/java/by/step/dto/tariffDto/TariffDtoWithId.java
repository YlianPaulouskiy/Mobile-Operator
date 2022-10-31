package by.step.dto.tariffDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TariffDtoWithId extends TariffDto {

    private Long id;
    private String dateCreation;

}
