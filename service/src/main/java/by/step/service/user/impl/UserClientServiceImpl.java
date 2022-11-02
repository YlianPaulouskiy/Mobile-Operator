package by.step.service.user.impl;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.mapper.ClientMapper;
import by.step.repository.ClientRepository;
import by.step.service.user.UserClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class UserClientServiceImpl implements UserClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDtoWithoutId findOneByName(ClientDto clientDto) {
        if (clientDto != null
                && clientRepository.existsByNameAndLastNameAndPatronymic(
                clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic())) {
            return clientMapper.convertToDtoWithoutId(clientRepository.findByNameAndLastNameAndPatronymic(
                    clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic()));
        } else {
            throw new EntityNotFoundException("Client  not found.");
        }
    }

    @Override
    public List<ClientDto> findAll() {
        return clientMapper.convertToDtoList(clientRepository.findAll());
    }

    @Override
    public Long getAmountClients() {
        return clientRepository.count();
    }
}
