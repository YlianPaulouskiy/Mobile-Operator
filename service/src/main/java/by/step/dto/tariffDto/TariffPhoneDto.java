package by.step.dto.tariffDto;

import by.step.dto.phoneDto.PhoneClientDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TariffPhoneDto extends TariffWithId{

    private PhoneClientDto phone;

}
