package by.step.dto.phoneDto;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.tariffDto.TariffPhoneDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneClientDto extends PhoneDtoWithId {

    private ClientPhoneDto client;

    private TariffPhoneDto tariff;

}
