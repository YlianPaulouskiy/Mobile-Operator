package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@Tag(name = "Phone menu")
public interface UserPhoneController extends BaseUserController<PhoneDtoWithoutId> {

    @Operation(summary = "Найти телефон по номеру", description = "Выводит данные о телефоне с заданным номером")
    @GetMapping("/findOneByNumber")
    PhoneDtoWithoutId findOneByNumber(@Valid @RequestBody PhoneDto phoneDto);

    @Operation(summary = "Найти телефоны по названию тарифа", description = "Выводит телефоны, которые используют данный тарифф")
    @GetMapping("/findPhonesByTariffName")
    List<PhoneDto> findPhonesByTariffName(@NotBlank @RequestParam String tariffName);

    @Operation(summary = "Найти телефон по ФИО клиента", description = "Выводит телефоны, которые использует данный клиент")
    @GetMapping("/findPhonesByClient")
    List<PhoneDto> findPhonesByClient(@Valid @RequestBody ClientDto clientDto);
}
