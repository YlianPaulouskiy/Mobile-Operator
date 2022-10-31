package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithoutId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserClientController extends BaseUserController<ClientDtoWithoutId> {

    @GetMapping("/findOneByName")
    ClientDtoWithoutId findOneByName(@RequestBody ClientDto clientDto);

    @GetMapping("/amountClients")
    Long getAmountClient();
}
