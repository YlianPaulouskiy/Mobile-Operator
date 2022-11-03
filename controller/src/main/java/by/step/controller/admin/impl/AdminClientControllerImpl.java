package by.step.controller.admin.impl;

import by.step.controller.admin.AdminClientController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.service.admin.AdminClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/client")
public class AdminClientControllerImpl implements AdminClientController {

    private final AdminClientService adminClientService;

    @Override
    public ClientPhoneDto findOneById(Long id) {
        return adminClientService.findOneById(id);
    }

    @Override
    public List<ClientDtoWithId> findAll() {
        return adminClientService.findAll();
    }

    @Override
    public ClientPhoneDto save(ClientDto entity) {
        return adminClientService.save(entity);
    }

    @Override
    public void removeById(Long id) {
        adminClientService.removeById(id);
    }

    @Override
    public Long getAmountClients() {
        return adminClientService.getAmountClients();
    }

    @Override
    public ClientPhoneDto addPhoneToClient(Long clientId, PhoneDto phoneDto) {
        return adminClientService.addPhoneByNumber(clientId, phoneDto);
    }

    @Override
    public ClientPhoneDto addPhoneToClient(Long clientId, Long phoneId) {
        return adminClientService.addPhoneById(clientId, phoneId);
    }
}
