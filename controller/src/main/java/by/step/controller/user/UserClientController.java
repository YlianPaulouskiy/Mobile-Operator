package by.step.controller.user;

import by.step.controller.parent.BaseUserController;
import by.step.dto.clientDto.ClientDtoWithoutId;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserClientController extends BaseUserController<ClientDtoWithoutId> {

    @GetMapping("/amountClients")
    Long getAmountClient();
}
