package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffPhoneDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AdminTariffController extends BaseAdminController<TariffDtoWithId> {

    @GetMapping("/findById")
    TariffPhoneDto findOneById(@RequestParam Long id);

    @GetMapping("/sortTariffByPrice")
    List<TariffDtoWithId> sortTariffByPrice();

    @GetMapping("/findTariffByParameters")
    TariffPhoneDto findTariffByParameters(
            @RequestParam Double priceFrom, @RequestParam Double priceTo,
            @RequestParam Integer minutesFrom, @RequestParam Integer minutesTo,
            @RequestParam Integer megabytesFrom, @RequestParam Integer megabytesTo
    );

    @PostMapping("/save")
    TariffPhoneDto save(@RequestBody TariffDto entity);

    @PutMapping("/addPhoneById")
    TariffPhoneDto addPhoneById(@RequestParam Long tariffId, @RequestParam Long phoneId);

    @PostMapping("/addPhoneByNumber")
    TariffPhoneDto addPhoneByNumber(@RequestParam Long tariffId, @RequestParam PhoneDto phoneDto);
}
