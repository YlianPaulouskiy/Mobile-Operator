package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserTariffController extends BaseUserController<TariffDto> {

    @GetMapping("/sortTariffByPrice")
    List<TariffDto> sortTariffByPrice();

    @GetMapping("/findTariffByParameters")
    TariffDto findTariffByParameters(
            @RequestParam Double priceFrom, @RequestParam Double priceTo,
            @RequestParam Integer minutesFrom, @RequestParam Integer minutesTo,
            @RequestParam Integer megabytesFrom, @RequestParam Integer megabytesTo
    );

}
