package by.step.dto.tariffDto;

import by.step.dto.phoneDto.PhoneClientDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TariffPhoneDto extends TariffDtoWithId {

    private PhoneClientDto phone;

}
