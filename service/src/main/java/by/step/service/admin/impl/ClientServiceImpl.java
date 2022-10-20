package by.step.service.admin.impl;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.entity.Client;
import by.step.mapper.ClientMapper;
import by.step.repository.ClientRepository;
import by.step.service.admin.ClientService;
import by.step.service.exception.EntityNotCorrectException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientPhoneDto findOneById(Long id) {
        return clientMapper.convertToDtoWithPhone(
                clientRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Client id# " + id + " not found.")
                )
        );
    }

    @Override
    public List<ClientPhoneDto> findAll() {
        return clientMapper.convertToClientPhoneDtoList(clientRepository.findAll());
    }

    // FIXME: 20.10.2022 check dateCreation and lastModified
    @Override
    public ClientPhoneDto save(ClientPhoneDto entity) {
        if (entity.getName().length() == 0 ||
        entity.getLastName().length() == 0 ||
        entity.getPatronymic().length() == 0) {
            throw new EntityNotCorrectException("Check input sources.");
        } else {
            return entity;
        }
    }

    @Override
    public void removeById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Client id# " + id + " not found.");
        }
    }

    @Override
    public Long getAmountClients() {
        return clientRepository.count();
    }
}
