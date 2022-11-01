package by.step.service.admin;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.service.parent.BaseAdminService;

public interface AdminPhoneService extends BaseAdminService<PhoneClientDto> {

    PhoneClientDto addClientById(Long phoneId, Long clientId);

    PhoneClientDto addClientByName(Long phoneId, ClientDto clientDto);

    PhoneClientDto addTariffById(Long phoneId, Long tariffId);

    PhoneClientDto save(PhoneDto phoneDto);

}
