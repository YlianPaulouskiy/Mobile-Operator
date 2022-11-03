package by.step.controller.user.impl;

import by.step.controller.user.UserPhoneController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneDto;
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
public class UserPhoneControllerImpl implements UserPhoneController {

    private final UserPhoneService userPhoneService;

    @Override
    public PhoneDtoWithoutId findOneByNumber(PhoneDto phoneDto) {
        return userPhoneService.findOneByNumber(phoneDto);
    }

    @Override
    public List<PhoneDto> findPhonesByTariffName(String tariffName) {
        return userPhoneService.findPhonesByTariffName(tariffName);
    }

    @Override
    public List<PhoneDto> findPhonesByClient(ClientDto clientDto) {
        return userPhoneService.findPhonesByClient(clientDto);
    }

    @Override
    public List<PhoneDtoWithoutId> findAll() {
        return userPhoneService.findAll();
    }
}
