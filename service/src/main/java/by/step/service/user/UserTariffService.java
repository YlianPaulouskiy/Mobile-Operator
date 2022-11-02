package by.step.service.user;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.service.parent.BaseUserService;

import java.util.List;

public interface UserTariffService extends BaseUserService<TariffDto> {

    List<TariffDto> sortTariffByPrice();

    TariffDto findByPriceAndMinutesAndMegabytes(
            Double priceFrom, Double priceTo,
            Integer minutesFrom, Integer minutesTo,
            Integer megabytesFrom, Integer megabytesTo
    );

    TariffDtoWithoutId findTariffByNameWithPhones(String tariffName);

    TariffDto findTariffByNameWithoutPhones(String tariffName);


}
