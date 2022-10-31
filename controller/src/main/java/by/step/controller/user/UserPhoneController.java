package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserPhoneController extends BaseUserController<PhoneDtoWithoutId> {

    @GetMapping("/findOneByNumber")
    PhoneDtoWithoutId findOneByNumber(@RequestBody PhoneDto phoneDto);

}
