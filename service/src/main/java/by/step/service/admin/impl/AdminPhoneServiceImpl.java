package by.step.service.admin.impl;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.entity.Client;
import by.step.entity.Phone;
import by.step.entity.Tariff;
import by.step.mapper.ClientMapper;
import by.step.mapper.PhoneMapper;
import by.step.repository.ClientRepository;
import by.step.repository.PhoneRepository;
import by.step.repository.TariffRepository;
import by.step.service.admin.AdminPhoneService;
import by.step.service.exception.EntityNotCorrectException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class AdminPhoneServiceImpl implements AdminPhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final TariffRepository tariffRepository;

    @Override
    public PhoneClientDto findOneById(Long id) {
        return phoneMapper.convertToDtoWithClient(
                phoneRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Phone id# " + id + " not found.")
                )
        );
    }

    @Override
    public List<PhoneClientDto> findAll() {
        return phoneMapper.convertToPhoneClientDtoList(phoneRepository.findAll());
    }

    @Override
    public PhoneClientDto save(PhoneClientDto entity) {
        if (entity != null) {
            if (!phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
                    entity.getCountryCode(), entity.getOperatorCode(), entity.getMobile())) {
                if (entity.getCountryCode().length() != 0
                        && entity.getOperatorCode().length() != 0
                        && entity.getMobile().length() != 0) {
                    return phoneMapper.convertToDtoWithClient(
                            phoneRepository.save(phoneMapper.convert(entity)));
                } else {
                    throw new EntityNotCorrectException("Check input sources.");
                }
            } else {
                throw new EntityExistsException("This phone already exists.");
            }
        } else {
            throw new EntityNotCorrectException("Input sources is null.");
        }
    }

    @Override
    public void removeById(Long id) {
        if (phoneRepository.existsById(id)) {
            phoneRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Phone id# " + id + " not found.");
        }
    }

    @Override
    public PhoneClientDto addClientById(Long phoneId, Long clientId) {
        if (phoneRepository.existsById(phoneId) && clientRepository.existsById(clientId)) {
            Phone phone = phoneMapper.convert(findOneById(phoneId));
            Client client = clientRepository.findById(clientId).get();
            if (phone.getClient() == null
                    || !phone.getClient().getId().equals(clientId)) {
                phone.setClient(client);
                client.getPhoneList().add(phone);
                phoneRepository.save(phone);
                clientRepository.save(client);
                return phoneMapper.convertToDtoWithClient(phone);
            } else {
                throw new EntityExistsException("Client already using this phone.");
            }
        } else {
            throw new EntityNotFoundException("Client id " + clientId + " or phone id " + phoneId + " doesn't exist.");
        }
    }

    @Override
    public PhoneClientDto addClientByName(Long phoneId, ClientDto clientDto) {
        if (phoneRepository.existsById(phoneId)) {
            if (clientDto.getName().length() != 0
                    && clientDto.getLastName().length() != 0
                    && clientDto.getPatronymic().length() != 0) {
                if (clientRepository.existsByNameAndLastNameAndPatronymic(
                        clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic())) {
                    Client client = clientRepository.findByNameAndLastNameAndPatronymic(
                            clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic());
                    return addClientById(phoneId, client.getId());
                } else {
                    Client client = clientMapper.convert(clientDto);
                    client = clientRepository.save(client);
                    return addClientById(phoneId, client.getId());
                }
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityNotFoundException("Phone id " + phoneId + " doesn't exist.");
        }
    }

    @Override
    public PhoneClientDto addTariffById(Long phoneId, Long tariffId) {
        if (phoneRepository.existsById(phoneId) && tariffRepository.existsById(tariffId)) {
            Phone phone = phoneMapper.convert(findOneById(phoneId));
            Tariff tariff = tariffRepository.findById(tariffId).get();
            if (phone.getTariff() == null
                    || !phone.getTariff().getId().equals(tariffId)) {
                phone.setTariff(tariff);
                tariff.getPhoneList().add(phone);
                phoneRepository.save(phone);
                tariffRepository.save(tariff);
                return phoneMapper.convertToDtoWithClient(phone);
            } else {
                throw new EntityExistsException("Phone already used this tariff.");
            }
        } else {
            throw new EntityNotFoundException("Tariff id " + tariffId + " or phone id " + phoneId + " doesn't exist.");
        }
    }

}
