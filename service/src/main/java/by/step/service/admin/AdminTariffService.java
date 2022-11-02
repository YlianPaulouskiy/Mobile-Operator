package by.step.service.admin;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.service.parent.BaseAdminService;

import java.util.List;

public interface AdminTariffService extends BaseAdminService<TariffDtoWithId> {

    TariffPhoneDto findOneById(Long id);

    List<TariffDtoWithId> sortTariffByPrice();

    TariffPhoneDto findByPriceAndMinutesAndMegabytes(
            Double priceFrom, Double priceTo,
            Integer minutesFrom, Integer minutesTo,
            Integer megabytesFrom, Integer megabytesTo
    );

    TariffPhoneDto save(TariffDto tariffDto);

    TariffPhoneDto addPhoneById(Long tariffId, Long phoneId);

    TariffPhoneDto addPhoneByNumber(Long tariffId, PhoneDto phoneDto);
}
