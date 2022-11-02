package by.step.service.user.impl;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.mapper.PhoneMapper;
import by.step.repository.PhoneRepository;
import by.step.service.exception.EntityNotCorrectException;
import by.step.service.user.UserPhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class UserPhoneServiceImpl implements UserPhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    // FIXME: 02.11.2022 DONT WORK https Error 400

    @Override
    public PhoneDtoWithoutId findOneByNumber(PhoneDto phoneDto) {
        if (phoneDto != null
                && phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
                phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile())) {
            return phoneMapper.convertToDtoWithoutId(phoneRepository.findByCountryCodeAndOperatorCodeAndMobile(
                    phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile()));
        } else {
            throw new EntityNotFoundException("Phone not found.");
        }
    }

    @Override
    public List<PhoneDtoWithoutId> findAll() {
        return phoneMapper.convertToDtoListWithoutId(phoneRepository.findAll());
    }

    @Override
    public List<PhoneDto> findPhonesByTariffName(String tariffName) {
        if (tariffName != null && tariffName.length() > 0) {
            return phoneMapper.convertToDtoList(
                    phoneRepository.findPhonesByTariffName(tariffName)
            );
        } else {
            throw new EntityNotCorrectException("Check Input Sources.");
        }
    }

    // FIXME: 02.11.2022 DONT WORK httpsError: 400
    @Override
    public List<PhoneDto> findPhonesByClient(ClientDto clientDto) {
        if (clientDto != null &&
                clientDto.getName().length() > 0
                && clientDto.getLastName().length() > 0
                && clientDto.getPatronymic().length() > 0) {
            return phoneMapper.convertToDtoList(
                    phoneRepository.findPhonesByClient(
                            clientDto.getName(), clientDto.getLastName(), clientDto.getPatronymic()
                    )
            );
        } else {
            throw new EntityNotCorrectException("Check Input Sources.");
        }
    }

}
