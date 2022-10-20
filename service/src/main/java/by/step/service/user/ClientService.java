package by.step.service.user;

import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.service.parent.BaseUserService;

public interface ClientService extends BaseUserService<ClientDtoWithoutId> {

    Long getAmountClients();

}
