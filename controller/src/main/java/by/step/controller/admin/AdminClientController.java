package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminClientController extends BaseAdminController<ClientPhoneDto> {

    @GetMapping("/amountClients")
    Long getAmountClients();

    @PostMapping("/addPhoneByNumber")
    ClientPhoneDto addPhoneToClient(@RequestParam Long clientId, @RequestBody PhoneDto phoneDto);

    @PostMapping("/addPhoneById")
    ClientPhoneDto addPhoneToClient(@RequestParam Long clientId, @RequestParam Long phoneId);


}
