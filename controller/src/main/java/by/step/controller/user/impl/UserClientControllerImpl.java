package by.step.controller.user.impl;

import by.step.controller.user.UserClientController;
import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.service.user.UserClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user/api/client")
public class UserClientControllerImpl implements UserClientController {

    private final UserClientService userClientService;

    @Override
    public ClientDtoWithoutId findOneByName(ClientDto clientDto) {
        return userClientService.findOneByName(clientDto);
    }

    @Override
    public List<ClientDto> findAll() {
        return userClientService.findAll();
    }

    @Override
    public Long getAmountClient() {
        return userClientService.getAmountClients();
    }
}
