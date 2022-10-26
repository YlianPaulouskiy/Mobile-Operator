package by.step.controller.user.impl;

import by.step.controller.user.UserTariffController;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.service.user.UserTariffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user/api/tariff")
@Tag(name = "Tariff menu", description = "Операции пользователя для работы с данными о тарифах")
public class UserTariffControllerImpl implements UserTariffController {

    private final UserTariffService userTariffService;

    @Operation(summary = "Найти тариф по Id", description = "Выводит тариф соответствующий заданному Id")
    @Override
    public TariffDtoWithoutId findOneById(Long id) {
        return userTariffService.findOneById(id);
    }

    @Operation(summary = "Найти все тарифы", description = "Выводит все существующие тарифы")
    @Override
    public List<TariffDtoWithoutId> findAll() {
        return userTariffService.findAll();
    }

    @Operation(summary = "Отсортировать тарифы по стоимости", description = "Выводит все существующие тарифы " +
            "отсортированные по стоимости")
    @Override
    public List<TariffDto> sortTariffByPrice() {
        return userTariffService.sortTariffByPrice();
    }

    @Operation(summary = "Найти тариф соответствующий параметрам", description = "Выводит тарифф соответствующий" +
            " заданным параметрам: цены, минутам, мегабайтам")
    @Override
    public TariffDto findTariffByParameters(Double priceFrom, Double priceTo, Integer minutesFrom,
                                            Integer minutesTo, Integer megabytesFrom, Integer megabytesTo) {
        return userTariffService.findByPriceAndMinutesAndMegabytes(priceFrom, priceTo, minutesFrom,
                minutesTo, megabytesFrom, megabytesTo);
    }
}
