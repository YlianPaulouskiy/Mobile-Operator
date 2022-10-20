package by.step.service.admin;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.service.parent.BaseAdminService;

public interface ClientService extends BaseAdminService<ClientPhoneDto> {

    Long getAmountClients();

}
