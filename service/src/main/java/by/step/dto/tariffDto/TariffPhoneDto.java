package by.step.dto.tariffDto;

import by.step.dto.phoneDto.PhoneDtoWithId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class TariffPhoneDto extends TariffDtoWithId {

    private List<PhoneDtoWithId> phoneList;

}
