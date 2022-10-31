package by.step.dto.tariffDto;

import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TariffDtoWithoutId extends TariffDto {

    private List<PhoneDto> phoneList;

}
