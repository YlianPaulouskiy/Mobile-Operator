package by.step.service.user;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.service.parent.BaseUserService;

public interface UserClientService extends BaseUserService<ClientDto> {

    ClientDtoWithoutId findOneByName(ClientDto clientDto);

    Long getAmountClients();

}
