package by.step.controller.user.impl;

import by.step.controller.user.UserClientController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.service.user.UserClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user/api/client")
@Tag(name = "Client menu", description = "Операции пользователя для работы с данными о клиентах")
public class UserClientControllerImpl implements UserClientController {

    private final UserClientService userClientService;

    @Operation(summary = "Найти клиента по ФИО", description = "Выводит клиента, соответствующего заданному ФИО")
    @Override
    public ClientDtoWithoutId findOneByName(ClientDto clientDto) {
        return userClientService.findOneByName(clientDto);
    }

    @Operation(summary = "Найти всех клиентов", description = "Выводит всех существующих клиентов")
    @Override
    public List<ClientDto> findAll() {
        return userClientService.findAll();
    }

    @Operation(summary = "Получить количество всех клиентов", description = "Выводит количество всех клиентов")
    @Override
    public Long getAmountClient() {
        return userClientService.getAmountClients();
    }
}
