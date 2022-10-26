package by.step.controller.user.impl;

import by.step.controller.user.UserPhoneController;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.service.user.UserPhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user/api/phone")
@Tag(name = "Phone menu", description = "Операции пользователя для работы с данными о телефонах")
public class UserPhoneControllerImpl implements UserPhoneController {

    private final UserPhoneService userPhoneService;

    @Operation(summary = "Найти телефон по Id", description = "Выводит данные о телефоне с заданным Id")
    @Override
    public PhoneDtoWithoutId findOneById(Long id) {
        return userPhoneService.findOneById(id);
    }

    @Operation(summary = "Найти все телефоны", description = "Выводит все существующие телефоны")
    @Override
    public List<PhoneDtoWithoutId> findAll() {
        return userPhoneService.findAll();
    }
}
