package by.step.service.admin;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.service.parent.BaseAdminService;

import java.util.List;

public interface TariffService extends BaseAdminService<TariffPhoneDto> {

    List<TariffDto> sortTariffByPrice();

    TariffDto findByPriceAndMinutesAndMegabytes(
            Double priceFrom, Double priceTo,
            Integer minutesFrom, Integer minutesTo,
            Integer megabytesFrom, Integer megabytesTo
    );

}
