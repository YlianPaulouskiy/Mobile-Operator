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
public class UserTariffControllerImpl implements UserTariffController {

    private final UserTariffService userTariffService;

    @Override
    public List<TariffDto> findAll() {
        return userTariffService.findAll();
    }

    @Override
    public List<TariffDto> sortTariffByPrice() {
        return userTariffService.sortTariffByPrice();
    }

    @Override
    public TariffDto findTariffByParameters(Double priceFrom, Double priceTo, Integer minutesFrom,
                                            Integer minutesTo, Integer megabytesFrom, Integer megabytesTo) {
        return userTariffService.findByPriceAndMinutesAndMegabytes(priceFrom, priceTo, minutesFrom,
                minutesTo, megabytesFrom, megabytesTo);
    }
}
