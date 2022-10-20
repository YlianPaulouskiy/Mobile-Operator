package by.step.service.admin;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.service.parent.BaseAdminService;

public interface AdminPhoneService extends BaseAdminService<PhoneClientDto> {

    PhoneClientDto addClientToPhone(Long phoneId, Long clientId);

    PhoneClientDto addClientToPhone(Long phoneId, ClientDto clientDto);

    PhoneClientDto addTariffToPhone(Long phoneId, Long tariffId);

}
