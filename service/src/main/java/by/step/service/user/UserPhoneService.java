package by.step.service.user;

import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.service.parent.BaseUserService;

public interface UserPhoneService extends BaseUserService<PhoneDtoWithoutId> {

    PhoneDtoWithoutId findOneByNumber(PhoneDto phoneDto);

}
