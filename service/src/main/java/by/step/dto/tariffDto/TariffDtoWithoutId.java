package by.step.dto.tariffDto;

import by.step.dto.phoneDto.PhoneDtoWithoutId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TariffDtoWithoutId extends TariffDto {

    private List<PhoneDtoWithoutId> phone;

}
