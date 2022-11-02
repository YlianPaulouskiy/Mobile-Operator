package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserPhoneController extends BaseUserController<PhoneDtoWithoutId> {

    @GetMapping("/findOneByNumber")
    PhoneDtoWithoutId findOneByNumber(@RequestBody PhoneDto phoneDto);

    @GetMapping("/findPhonesByTariffName")
    List<PhoneDto> findPhonesByTariffName(@RequestParam String tariffName);

    @GetMapping("/findPhonesByClient")
    List<PhoneDto> findPhonesByClient(@RequestBody ClientDto clientDto);
}
