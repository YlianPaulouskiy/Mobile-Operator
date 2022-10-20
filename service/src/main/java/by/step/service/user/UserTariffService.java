package by.step.service.user;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.service.parent.BaseUserService;

import java.util.List;

public interface UserTariffService extends BaseUserService<TariffDtoWithoutId> {

    List<TariffDto> sortTariffByPrice();

    TariffDto findByPriceAndMinutesAndMegabytes(
            Double priceFrom, Double priceTo,
            Integer minutesFrom, Integer minutesTo,
            Integer megabytesFrom, Integer megabytesTo
    );
}
