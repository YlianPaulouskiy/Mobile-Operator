package by.step.controller.admin;

import by.step.controller.parent.BaseAdminController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import org.springframework.web.bind.annotation.*;

public interface AdminClientController extends BaseAdminController<ClientDtoWithId> {

    @GetMapping("/findById")
    ClientPhoneDto findOneById(@RequestParam Long id);

    @GetMapping("/amountClients")
    Long getAmountClients();

    @PostMapping("/addPhoneByNumber")
    ClientPhoneDto addPhoneToClient(@RequestParam Long clientId, @RequestBody PhoneDto phoneDto);

    @PutMapping("/addPhoneById")
    ClientPhoneDto addPhoneToClient(@RequestParam Long clientId, @RequestParam Long phoneId);

    @PostMapping("/save")
    ClientPhoneDto save(@RequestBody ClientDto entity);



}
