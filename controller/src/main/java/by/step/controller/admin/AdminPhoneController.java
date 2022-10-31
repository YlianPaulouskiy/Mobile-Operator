package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneClientDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminPhoneController extends BaseAdminController<PhoneClientDto> {

    @PostMapping("/addClientById")
    PhoneClientDto addClientToPhone(@RequestParam Long phoneId, @RequestParam Long clientId);

    @PostMapping("/addClientByName")
    PhoneClientDto addClientToPhone(@RequestParam Long phoneId, @RequestBody ClientDto clientDto);

    @PostMapping("/addTariffById")
    PhoneClientDto addTariffToPhone(@RequestParam Long phoneId, @RequestParam Long tariffId);
}
