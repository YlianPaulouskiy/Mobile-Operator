package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AdminPhoneController extends BaseAdminController<PhoneClientDto> {

    @GetMapping("/findById")
    PhoneClientDto findOneById(@RequestParam Long id);

    @PutMapping("/addClientById")
    PhoneClientDto addClientToPhone(@RequestParam Long phoneId, @RequestParam Long clientId);

    @PostMapping("/addClientByName")
    PhoneClientDto addClientToPhone(@RequestParam Long phoneId, @RequestBody ClientDto clientDto);

    @PutMapping("/addTariffById")
    PhoneClientDto addTariffToPhone(@RequestParam Long phoneId, @RequestParam Long tariffId);

    @PostMapping("/save")
    PhoneClientDto save(@RequestBody PhoneDto entity);

    @GetMapping("/findPhonesByTariffName")
    List<PhoneDtoWithId> findPhonesByTariffName(@RequestParam String tariffName);

    @GetMapping("/findPhonesByClient")
    List<PhoneDtoWithId> findPhonesByClient(@RequestBody ClientDto clientDto);

}
