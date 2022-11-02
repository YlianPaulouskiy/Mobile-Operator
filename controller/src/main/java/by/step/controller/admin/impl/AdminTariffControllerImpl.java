package by.step.controller.admin.impl;

import by.step.controller.admin.AdminTariffController;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.service.admin.AdminTariffService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/api/tariff")
@Tag(name = "Tariff menu")
public class AdminTariffControllerImpl implements AdminTariffController {

    private final AdminTariffService adminTariffService;

    @Operation(summary = "Найти тариф по Id", description = "Выводит тариф соответствующий заданному Id")
    @Override
    public TariffPhoneDto findOneById(Long id) {
        return adminTariffService.findOneById(id);
    }

    @Operation(summary = "Найти все тарифы", description = "Выводит все существующие тарифы")
    @Override
    public List<TariffDtoWithId> findAll() {
        return adminTariffService.findAll();
    }

    @Operation(summary = "Сохранить тариф", description = "Сохраняет новый тариф в базу данных")
    @Override
    public TariffPhoneDto save(TariffDto entity) {
        return adminTariffService.save(entity);
    }

    @Operation(summary = "Удалить тариф по Id", description = "Удаляет тариф из базы данных по заданному Id")
    @Override
    public void removeById(Long id) {
        adminTariffService.removeById(id);
    }

    @Operation(summary = "Отсортировать тарифы по стоимости", description = "Выводит все существующие тарифы " +
            "отсортированные по стоимости")
    @Override
    public List<TariffDtoWithId> sortTariffByPrice() {
        return adminTariffService.sortTariffByPrice();
    }

    @Operation(summary = "Найти тариф соответствующий параметрам", description = "Выводит тарифф соответствующий" +
            " заданным параметрам: цены, минутам, мегабайтам")
    @Override
    public TariffPhoneDto findTariffByParameters(Double priceFrom, Double priceTo, Integer minutesFrom,
                                                 Integer minutesTo, Integer megabytesFrom, Integer megabytesTo) {
        return adminTariffService.findByPriceAndMinutesAndMegabytes(priceFrom, priceTo, minutesFrom,
                minutesTo, megabytesFrom, megabytesTo);
    }

    @Operation(summary = "Добавить Телефон по Id", description = "Добавляет телефона к тарифу по Id," +
            "если телефон не использует данные тариф")
    @Override
    public TariffPhoneDto addPhoneById(Long tariffId, Long phoneId) {
        return adminTariffService.addPhoneById(tariffId, phoneId);
    }

    @Operation(summary = "Добавить Телефон по номеру", description = "Добавляет телефона к тарифу по номеру," +
            "если телефон не использует данные тариф")
    @Override
    public TariffPhoneDto addPhoneByNumber(Long tariffId, PhoneDto phoneDto) {
        return adminTariffService.addPhoneByNumber(tariffId, phoneDto);
    }
}
