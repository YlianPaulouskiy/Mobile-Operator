package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithoutId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Tag(name = "Client menu")
public interface UserClientController extends BaseUserController<ClientDto> {

    @Operation(summary = "Найти клиента по ФИО", description = "Выводит клиента, соответствующего заданному ФИО")
    @GetMapping("/findOneByName")
    ClientDtoWithoutId findOneByName(@Valid @RequestBody ClientDto clientDto);

    @Operation(summary = "Получить количество всех клиентов", description = "Выводит количество всех клиентов")
    @GetMapping("/amountClients")
    Long getAmountClient();
}
