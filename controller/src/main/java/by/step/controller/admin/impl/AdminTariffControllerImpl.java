package by.step.controller.admin.impl;

import by.step.controller.admin.AdminTariffController;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.service.admin.AdminTariffService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/tariff")
public class AdminTariffControllerImpl implements AdminTariffController {

    private final AdminTariffService adminTariffService;

    @Override
    public TariffPhoneDto findOneById(Long id) {
        return adminTariffService.findOneById(id);
    }

    @Override
    public List<TariffDtoWithId> findAll() {
        return adminTariffService.findAll();
    }

    @Override
    public TariffPhoneDto save(TariffDto entity) {
        return adminTariffService.save(entity);
    }

    @Override
    public void removeById(Long id) {
        adminTariffService.removeById(id);
    }

    @Override
    public List<TariffDtoWithId> sortTariffByPrice() {
        return adminTariffService.sortTariffByPrice();
    }

    @Override
    public TariffPhoneDto findTariffByParameters(Double priceFrom, Double priceTo, Integer minutesFrom,
                                                 Integer minutesTo, Integer megabytesFrom, Integer megabytesTo) {
        return adminTariffService.findByPriceAndMinutesAndMegabytes(priceFrom, priceTo, minutesFrom,
                minutesTo, megabytesFrom, megabytesTo);
    }

    @Override
    public TariffPhoneDto addPhoneById(Long tariffId, Long phoneId) {
        return adminTariffService.addPhoneById(tariffId, phoneId);
    }

    @Override
    public TariffPhoneDto addPhoneByNumber(Long tariffId, PhoneDto phoneDto) {
        return adminTariffService.addPhoneByNumber(tariffId, phoneDto);
    }
}
