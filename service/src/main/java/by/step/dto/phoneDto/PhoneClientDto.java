package by.step.dto.phoneDto;

import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.tariffDto.TariffDtoWithId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PhoneClientDto extends PhoneDtoWithId {

    private ClientDtoWithId client;
    private TariffDtoWithId tariff;

}
