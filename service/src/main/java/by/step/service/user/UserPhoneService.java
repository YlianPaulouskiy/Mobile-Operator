package by.step.service.user;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.dto.tariffDto.TariffDto;
import by.step.service.parent.BaseUserService;

import java.util.List;

public interface UserPhoneService extends BaseUserService<PhoneDtoWithoutId> {

    PhoneDtoWithoutId findOneByNumber(PhoneDto phoneDto);

    List<PhoneDto> findPhonesByTariffName(String tariffName);

    List<PhoneDto> findPhonesByClient(ClientDto clientDto);

}
