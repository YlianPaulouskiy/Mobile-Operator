package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@Tag(name = "Client menu")
public interface AdminClientController extends BaseAdminController<ClientDtoWithId> {

    @Operation(summary = "Получить количество всех клиентов", description = "Выводит количество всех клиентов")
    @GetMapping("/amountClients")
    Long getAmountClients();

    @Operation(summary = "Добавить телефон к клиенту", description = "Привязывает телефон к клиенту," +
            " если он до этого был не привязан, при этом телефон задается явно")
    @PostMapping("/addPhoneByNumber")
    ClientPhoneDto addPhoneToClient(@NotNull @Positive @RequestParam Long clientId, @Valid @RequestBody PhoneDto phoneDto);

    @Operation(summary = "Добавить телефон к клиенту", description = "Привязывает телефон к клиенту, " +
            "если он до этого момента не был привязан, при этом телефон задается при помощи Id")
    @PutMapping("/addPhoneById")
    ClientPhoneDto addPhoneToClient(@NotNull @Positive @RequestParam Long clientId, @RequestParam Long phoneId);

    @Operation(summary = "Сохранить клиента", description = "Сохраняет информацию о клиенте в базу данных")
    @PostMapping("/save")
    ClientPhoneDto save(@Valid @RequestBody ClientDto entity);



}
