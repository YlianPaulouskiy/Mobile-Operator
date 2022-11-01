package by.step.service.admin;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.service.parent.BaseAdminService;

public interface AdminClientService extends BaseAdminService<ClientPhoneDto> {

    Long getAmountClients();

    ClientPhoneDto addPhoneByNumber(Long clientId, PhoneDto phoneDto);

    ClientPhoneDto addPhoneById(Long clientId, Long phoneId);
    ClientPhoneDto save(ClientDto clientDto);

}
