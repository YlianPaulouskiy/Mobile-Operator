package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.tariffDto.TariffPhoneDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AdminTariffController extends BaseAdminController<TariffPhoneDto> {

    @GetMapping("/sortTariffByPrice")
    List<TariffPhoneDto> sortTariffByPrice();

    @GetMapping("/findTariffByParameters")
    TariffPhoneDto findTariffByParameters(
            @RequestParam Double priceFrom, @RequestParam Double priceTo,
            @RequestParam Integer minutesFrom, @RequestParam Integer minutesTo,
            @RequestParam Integer megabytesFrom, @RequestParam Integer megabytesTo
    );
}
