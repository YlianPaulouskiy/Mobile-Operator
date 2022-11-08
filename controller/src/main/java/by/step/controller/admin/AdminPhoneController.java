package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@Tag(name = "Phone menu")
public interface AdminPhoneController extends BaseAdminController<PhoneClientDto> {

    @Operation(summary = "Добавить клиента к телефону", description = "Привязывает клиента к телефону, " +
            "если он до этого момента не был привязан, при этом клиент задается при помощи Id")
    @PutMapping("/addClientById")
    PhoneClientDto addClientToPhone(@NotNull @Positive @RequestParam Long phoneId,
                                    @NotNull @Positive @RequestParam Long clientId);

    @Operation(summary = "Добавить клиента к телефону", description = "Привязывает клиента к телефону, " +
            " если он до этого был не привязан, при этом клиент задается явно")
    @PostMapping("/addClientByName")
    PhoneClientDto addClientToPhone(@NotNull @Positive @RequestParam Long phoneId,
                                    @Valid @RequestBody ClientDto clientDto);

    @Operation(summary = "Добавить тариф к номеру телефона", description = "Привязывает тарифф к номеру телефона, " +
            " если он до этого был не привязан, или перепривязывает новый тариф,  при этом тариф задается с помощью Id")
    @PutMapping("/addTariffById")
    PhoneClientDto addTariffToPhone(@NotNull @Positive @RequestParam Long phoneId,
                                    @NotNull @Positive @RequestParam Long tariffId);

    @Operation(summary = "Сохранить телефон", description = "Сохраняет телефон в базу данных")
    @PostMapping("/save")
    PhoneClientDto save(@Valid @RequestBody PhoneDto entity);

    @Operation(summary = "Найти телефоны по названию тарифа", description = "Выводит телефоны, которые используют данный тарифф")
    @GetMapping("/findPhonesByTariffName")
    List<PhoneDtoWithId> findPhonesByTariffName(@NotBlank @RequestParam String tariffName);

    @Operation(summary = "Найти телефон по ФИО клиента", description = "Выводит телефоны, которые использует данный клиент")
    @GetMapping("/findPhonesByClient")
    List<PhoneDtoWithId> findPhonesByClient(@Valid @RequestBody ClientDto clientDto);

}
