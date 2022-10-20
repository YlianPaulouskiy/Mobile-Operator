package by.step.service.user.impl;

import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.mapper.ClientMapper;
import by.step.repository.ClientRepository;
import by.step.service.user.ClientService;
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
    public ClientDtoWithoutId findOneById(Long id) {
        return clientMapper.convertToDtoWithoutId(
                clientRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Client #" + id + " not found.")
                )
        );
    }

    @Override
    public List<ClientDtoWithoutId> findAll() {
        return clientMapper.convertToDtoListWithoutId(clientRepository.findAll());
    }

    @Override
    public Long getAmountClients() {
        return clientRepository.count();
    }
}
