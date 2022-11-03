package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.tariffDto.TariffDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@Tag(name = "Tariff menu")
public interface UserTariffController extends BaseUserController<TariffDto> {

    @Operation(summary = "Отсортировать тарифы по стоимости", description = "Выводит все существующие тарифы " +
            "отсортированные по стоимости")
    @GetMapping("/sortTariffByPrice")
    List<TariffDto> sortTariffByPrice();

    @Operation(summary = "Найти тариф соответствующий параметрам", description = "Выводит тарифф соответствующий" +
            " заданным параметрам: цены, минутам, мегабайтам")
    @GetMapping("/findTariffByParameters")
    TariffDto findTariffByParameters(
            @NotNull @Positive @RequestParam Double priceFrom, @NotNull @Positive @RequestParam Double priceTo,
            @NotNull @Positive @RequestParam Integer minutesFrom, @NotNull @Positive @RequestParam Integer minutesTo,
            @NotNull @Positive @RequestParam Integer megabytesFrom, @NotNull @Positive @RequestParam Integer megabytesTo
    );

}
