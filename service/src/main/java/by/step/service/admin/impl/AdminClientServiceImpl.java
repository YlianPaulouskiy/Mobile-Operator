package by.step.service.admin.impl;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.entity.Phone;
import by.step.mapper.ClientMapper;
import by.step.mapper.PhoneMapper;
import by.step.repository.ClientRepository;
import by.step.repository.PhoneRepository;
import by.step.service.admin.AdminClientService;
import by.step.service.exception.EntityNotCorrectException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class AdminClientServiceImpl implements AdminClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

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
    public ClientPhoneDto addPhoneToClient(Long clientId, PhoneDto phoneDto) {
        if (clientRepository.existsById(clientId) && phoneDto != null) {
            if (phoneDto.getCountryCode().length() > 2
                    || phoneDto.getOperatorCode().length() > 2
                    || phoneDto.getMobile().length() > 5) {
                Phone phone = phoneMapper.convert(phoneDto);
                ClientPhoneDto clientPhoneDto = findOneById(clientId);
                clientPhoneDto.getPhoneList().add(phoneMapper.convertToDtoWithClient(phone));
                return clientPhoneDto;
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityNotFoundException("Client id# " + clientId + " not found.");
        }
    }

    @Override
    public ClientPhoneDto addPhoneToClient(Long clientId, Long phoneId) {
        if (clientRepository.existsById(clientId) && phoneRepository.existsById(phoneId)) {
            ClientPhoneDto clientPhoneDto = findOneById(clientId);
            PhoneClientDto phoneClientDto =phoneMapper
                    .convertToDtoWithClient(phoneRepository.findById(phoneId).get());
            if (!clientPhoneDto.getPhoneList().contains(phoneClientDto)) {
                clientPhoneDto.getPhoneList().add(phoneClientDto);
            } else {
                throw new EntityExistsException("Client already using this phone.");
            }
            return clientPhoneDto;
        } else {
            throw new EntityNotFoundException("Client id " + clientId + " or phone id " + phoneId + " doesn't exist.");
        }
    }

    @Override
    public Long getAmountClients() {
        return clientRepository.count();
    }
}
