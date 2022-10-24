package by.step.service.admin;

import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.service.parent.BaseAdminService;

import java.util.List;

public interface AdminTariffService extends BaseAdminService<TariffPhoneDto> {

    List<TariffPhoneDto> sortTariffByPrice();

    TariffPhoneDto findByPriceAndMinutesAndMegabytes(
            Double priceFrom, Double priceTo,
            Integer minutesFrom, Integer minutesTo,
            Integer megabytesFrom, Integer megabytesTo
    );

}
