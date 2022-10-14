package by.step.dto.tariffDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TariffDtoWithId extends TariffDto {

    private Long id;

    private String dateCreation;

    private String lastModified;

    private Long version;

}
