package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffPhoneDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@Tag(name = "Tariff menu")
public interface AdminTariffController extends BaseAdminController<TariffDtoWithId> {

    @Operation(summary = "Отсортировать тарифы по стоимости", description = "Выводит все существующие тарифы " +
            "отсортированные по стоимости")
    @GetMapping("/sortTariffByPrice")
    List<TariffDtoWithId> sortTariffByPrice();

    @Operation(summary = "Найти тариф соответствующий параметрам", description = "Выводит тарифф соответствующий" +
            " заданным параметрам: цены, минутам, мегабайтам")
    @GetMapping("/findTariffByParameters")
    TariffPhoneDto findTariffByParameters(
            @NotNull @Positive @RequestParam Double priceFrom, @NotNull @Positive @RequestParam Double priceTo,
            @NotNull @Positive @RequestParam Integer minutesFrom, @NotNull @Positive @RequestParam Integer minutesTo,
            @NotNull @Positive @RequestParam Integer megabytesFrom, @NotNull @Positive @RequestParam Integer megabytesTo
    );

    @Operation(summary = "Сохранить тариф", description = "Сохраняет новый тариф в базу данных")
    @PostMapping("/save")
    TariffPhoneDto save(@Valid @RequestBody TariffDto entity);

    @Operation(summary = "Добавить Телефон по Id", description = "Добавляет телефона к тарифу по Id," +
            "если телефон не использует данные тариф")
    @PutMapping("/addPhoneById")
    TariffPhoneDto addPhoneById(@NotNull @Positive @RequestParam Long tariffId,
                                @NotNull @Positive @RequestParam Long phoneId);

    @Operation(summary = "Добавить Телефон по номеру", description = "Добавляет телефона к тарифу по номеру," +
            "если телефон не использует данные тариф")
    @PostMapping("/addPhoneByNumber")
    TariffPhoneDto addPhoneByNumber(@NotNull @Positive @RequestParam Long tariffId,
                                    @Valid @RequestParam PhoneDto phoneDto);
}
