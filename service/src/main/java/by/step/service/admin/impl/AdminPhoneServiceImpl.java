package by.step.service.admin.impl;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.entity.Client;
import by.step.mapper.ClientMapper;
import by.step.mapper.PhoneMapper;
import by.step.mapper.TariffMapper;
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
    private final TariffMapper tariffMapper;


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
        if (!phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
                entity.getCountryCode(), entity.getOperatorCode(), entity.getMobile())) {
            if (entity.getCountryCode().length() >= 2
                    || entity.getOperatorCode().length() >= 2
                    || entity.getMobile().length() >= 5) {
                return phoneMapper.convertToDtoWithClient(
                        phoneRepository.save(
                                phoneMapper.convert(entity)
                        )
                );
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityExistsException("This phone already exists.");
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
    public PhoneClientDto addClientToPhone(Long phoneId, Long clientId) {
        if (phoneRepository.existsById(phoneId) && clientRepository.existsById(clientId)) {
            PhoneClientDto phoneClientDto = findOneById(clientId);
            ClientPhoneDto clientPhoneDto = clientMapper
                    .convertToDtoWithPhone(clientRepository.findById(clientId).get());
            if (clientPhoneDto.getPhoneList() != null
                    && !clientPhoneDto.getPhoneList().contains(phoneClientDto)) {
                clientPhoneDto.getPhoneList().add(phoneClientDto);
                phoneClientDto.setClient(clientPhoneDto);
                // засэйвить в базу
                clientRepository.save(clientMapper.convert(clientPhoneDto));
                phoneRepository.save(phoneMapper.convert(phoneClientDto));
            } else {
                throw new EntityExistsException("Client already using this phone.");
            }
            return phoneClientDto;
        } else {
            throw new EntityNotFoundException("Client id " + clientId + " or phone id " + phoneId + " doesn't exist.");
        }
    }

    @Override
    public PhoneClientDto addClientToPhone(Long phoneId, ClientDto clientDto) {
        if (phoneRepository.existsById(phoneId)) {
            if (clientDto.getName().length() != 0
                    && clientDto.getLastName().length() != 0
                    && clientDto.getPatronymic().length() != 0) {
                if (clientRepository.existsByNameAndLastNameAndPatronymic(
                        clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic())) {
                    Client client = clientRepository.findByNameAndLastNameAndPatronymic(
                            clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic());
                    return addClientToPhone(phoneId, client.getId());
                } else {
                    Client client = clientMapper.convert(clientDto);
                    client = clientRepository.save(client);
                    return addClientToPhone(phoneId, client.getId());
                }
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityNotFoundException("Phone id " + phoneId + " doesn't exist.");
        }
    }

    // FIXME: 24.10.2022 NEED COMPLETE
    @Override
    public PhoneClientDto addTariffToPhone(Long phoneId, Long tariffId) {
        if (phoneRepository.existsById(phoneId) && tariffRepository.existsById(tariffId)) {
            PhoneClientDto phoneClientDto = findOneById(phoneId);

        } else {
            throw new EntityNotFoundException("Tariff id " + tariffId + " or phone id " + phoneId + " doesn't exist.");
        }
        return null;
    }

}
