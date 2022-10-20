package by.step.dto.phoneDto;

import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneDtoWithoutId extends PhoneDto {

    private ClientDtoWithoutId client;

    private TariffDtoWithoutId tariff;

}
