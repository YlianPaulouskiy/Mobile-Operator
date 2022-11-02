package by.step.service.admin;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import by.step.service.parent.BaseAdminService;

import java.util.List;

public interface AdminPhoneService extends BaseAdminService<PhoneClientDto> {

    PhoneClientDto findOneById(Long id);

    PhoneClientDto addClientById(Long phoneId, Long clientId);

    PhoneClientDto addClientByName(Long phoneId, ClientDto clientDto);

    PhoneClientDto addTariffById(Long phoneId, Long tariffId);

    PhoneClientDto save(PhoneDto phoneDto);

    List<PhoneDtoWithId> findPhonesByTariffName(String tariffName);

    List<PhoneDtoWithId> findPhonesByClient(ClientDto clientDto);

}
