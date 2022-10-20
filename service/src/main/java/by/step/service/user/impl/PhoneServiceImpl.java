package by.step.service.user.impl;

import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.mapper.PhoneMapper;
import by.step.repository.PhoneRepository;
import by.step.service.user.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public PhoneDtoWithoutId findOneById(Long id) {
        return phoneMapper.convertToDtoWithoutId(
                phoneRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Phone #" + id + " not found." )
                )
        );
    }

    @Override
    public List<PhoneDtoWithoutId> findAll() {
        return phoneMapper.convertToDtoListWithoutId(phoneRepository.findAll());
    }

}
