package by.step.service.user.impl;

import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.mapper.PhoneMapper;
import by.step.repository.PhoneRepository;
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

}
