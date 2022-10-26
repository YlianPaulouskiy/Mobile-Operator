package by.step.controller.admin.impl;

import by.step.controller.admin.AdminClientController;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.service.admin.AdminClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/client")
@Tag(name = "Client menu", description = "Операции администратора для работы с данными о клиентах")
public class AdminClientControllerImpl implements AdminClientController {

    private final AdminClientService adminClientService;

    @Operation(summary = "Найти клиента по Id", description = "Выводит клиента, соответствующего заданному Id")
    @Override
    public ClientPhoneDto findOneById(Long id) {
        return adminClientService.findOneById(id);
    }

    @Operation(summary = "Найти всех клиентов", description = "Выводит всех существующих клиентов")
    @Override
    public List<ClientPhoneDto> findAll() {
        return adminClientService.findAll();
    }

    @Operation(summary = "Сохранить клиента", description = "Сохраняет информацию о клиенте в базу данных")
    @Override
    public ClientPhoneDto save(ClientPhoneDto entity) {
        return adminClientService.save(entity);
    }

    @Operation(summary = "Удалить клиента по Id", description = "Удаляет клиента с заданным Id из базы данных")
    @Override
    public void removeById(Long id) {
        adminClientService.removeById(id);
    }

    @Operation(summary = "Получить количество всех клиентов", description = "Выводит количество всех клиентов")
    @Override
    public Long getAmountClients() {
        return adminClientService.getAmountClients();
    }

    @Operation(summary = "Добавить телефон к клиенту", description = "Привязывает телефон к клиенту," +
            " если он до этого был не привязан, при этом телефон задается явно")
    @Override
    public ClientPhoneDto addPhoneToClient(Long clientId, PhoneDto phoneDto) {
        return adminClientService.addPhoneToClient(clientId, phoneDto);
    }

    @Operation(summary = "Добавить телефон к клиенту", description = "Привязывает телефон к клиенту, " +
            "если он до этого момента не был привязан, при этом телефон задается при помощи Id")
    @Override
    public ClientPhoneDto addPhoneToClient(Long clientId, Long phoneId) {
        return adminClientService.addPhoneToClient(clientId, phoneId);
    }
}
