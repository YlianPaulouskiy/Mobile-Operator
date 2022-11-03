package by.step.controller.admin.impl;

import by.step.controller.admin.AdminPhoneController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import by.step.service.admin.AdminPhoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/phone")
public class AdminPhoneControllerImpl implements AdminPhoneController {

    private final AdminPhoneService adminPhoneService;

    @Override
    public PhoneClientDto findOneById(Long id) {
        return adminPhoneService.findOneById(id);
    }

    @Override
    public List<PhoneClientDto> findAll() {
        return adminPhoneService.findAll();
    }

    @Override
    public List<PhoneDtoWithId> findPhonesByTariffName(String tariffName) {
        return adminPhoneService.findPhonesByTariffName(tariffName);
    }

    @Override
    public List<PhoneDtoWithId> findPhonesByClient(ClientDto clientDto) {
        return adminPhoneService.findPhonesByClient(clientDto);
    }

    @Override
    public PhoneClientDto save(PhoneDto entity) {
        return adminPhoneService.save(entity);
    }

    @Override
    public void removeById(Long id) {
        adminPhoneService.removeById(id);
    }

    @Override
    public PhoneClientDto addClientToPhone(Long phoneId, Long clientId) {
        return adminPhoneService.addClientById(phoneId, clientId);
    }

    @Override
    public PhoneClientDto addClientToPhone(Long phoneId, ClientDto clientDto) {
        return adminPhoneService.addClientByName(phoneId, clientDto);
    }

    @Override
    public PhoneClientDto addTariffToPhone(Long phoneId, Long tariffId) {
        return adminPhoneService.addTariffById(phoneId, tariffId);
    }
}
