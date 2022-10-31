package by.step.service.admin.impl;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.entity.Client;
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

    @Override
    public ClientPhoneDto save(ClientPhoneDto entity) {
        if (entity != null) {
            if (!clientRepository.existsByNameAndLastNameAndPatronymic(
                    entity.getName(), entity.getLastName(), entity.getPatronymic())) {
                if (entity.getName().length() == 0
                        || entity.getLastName().length() == 0
                        || entity.getPatronymic().length() == 0) {
                    throw new EntityNotCorrectException("Check input sources.");
                } else {
                    return clientMapper.convertToDtoWithPhone(
                            clientRepository.save(clientMapper.convert(entity)));
                }
            } else {
                throw new EntityExistsException("Client already exists.");
            }
        } else {
            throw new EntityNotCorrectException("Input source is null.");
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
    public ClientPhoneDto addPhoneByNumber(Long clientId, PhoneDto phoneDto) {
        if (clientRepository.existsById(clientId)) {
            if (phoneDto.getCountryCode().length() != 0
                    && phoneDto.getOperatorCode().length() != 0
                    && phoneDto.getMobile().length() != 0) {
                if (phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
                        phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile())) {
                    Phone phone = phoneRepository.findByCountryCodeAndOperatorCodeAndMobile(
                            phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile());
                    return addPhoneById(clientId, phone.getId());
                } else {
                    Phone phone = phoneMapper.convert(phoneDto);
                    phone = phoneRepository.save(phone);
                    return addPhoneById(clientId, phone.getId());
                }
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityNotFoundException("Client id# " + clientId + " not found.");
        }
    }

    @Override
    public ClientPhoneDto addPhoneById(Long clientId, Long phoneId) {
        if (clientRepository.existsById(clientId) && phoneRepository.existsById(phoneId)) {
            Client client = clientMapper.convert(findOneById(clientId));
            Phone phone = phoneRepository.findById(phoneId).get();
            if (phone.getClient() == null
                    || !phone.getClient().getId().equals(clientId)) {
                client.getPhoneList().add(phone);
                phone.setClient(client);
                clientRepository.save(client);
                phoneRepository.save(phone);
                return clientMapper.convertToDtoWithPhone(client);
            } else {
                throw new EntityExistsException("Client already using this phone.");
            }
        } else {
            throw new EntityNotFoundException("Client id " + clientId + " or phone id " + phoneId + " doesn't exist.");
        }
    }

    @Override
    public Long getAmountClients() {
        return clientRepository.count();
    }
}

