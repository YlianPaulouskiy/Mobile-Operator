package by.step.controller.admin.impl;

import by.step.controller.admin.AdminPhoneController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.service.admin.AdminPhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/phone")
@Tag(name = "Phone menu", description = "Операции администратора для работы с данными о телефонах")
public class AdminPhoneControllerImpl implements AdminPhoneController {

    private final AdminPhoneService adminPhoneService;

    @Operation(summary = "Найти телефон по Id", description = "Выводит данные о телефоне с заданным Id")
    @Override
    public PhoneClientDto findOneById(Long id) {
        return adminPhoneService.findOneById(id);
    }

    @Operation(summary = "Найти все телефоны", description = "Выводит все существующие телефоны")
    @Override
    public List<PhoneClientDto> findAll() {
        return adminPhoneService.findAll();
    }

    @Operation(summary = "Сохранить телефон", description = "Сохраняет телефон в базу данных")
    @Override
    public PhoneClientDto save(PhoneClientDto entity) {
        return adminPhoneService.save(entity);
    }

    @Operation(summary = "Удалить телефон по Id", description = "Удаляет телефон с заданным Id из базы данных")
    @Override
    public void removeById(Long id) {
        adminPhoneService.removeById(id);
    }

    @Operation(summary = "Добавить клиента к телефону", description = "Привязывает клиента к телефону, " +
            "если он до этого момента не был привязан, при этом клиент задается при помощи Id")
    @Override
    public PhoneClientDto addClientToPhone(Long phoneId, Long clientId) {
        return adminPhoneService.addClientById(phoneId, clientId);
    }

    @Operation(summary = "Добавить клиента к телефону", description = "Привязывает клиента к телефону, " +
            " если он до этого был не привязан, при этом клиент задается явно")
    @Override
    public PhoneClientDto addClientToPhone(Long phoneId, ClientDto clientDto) {
        return adminPhoneService.addClientByName(phoneId, clientDto);
    }

    @Operation(summary = "Добавить тариф к номеру телефона", description = "Привязывает тарифф к номеру телефона, " +
            " если он до этого был не привязан, или перепривязывает новый тариф,  при этом тариф задается с помощью Id")
    @Override
    public PhoneClientDto addTariffToPhone(Long phoneId, Long tariffId) {
        return adminPhoneService.addTariffById(phoneId, tariffId);
    }
}
