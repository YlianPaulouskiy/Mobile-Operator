package by.step.service.user.impl;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.mapper.TariffMapper;
import by.step.repository.TariffRepository;
import by.step.service.exception.EntityNotCorrectException;
import by.step.service.user.UserTariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class UserTariffServiceImpl implements UserTariffService {

    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;

    @Override
    public List<TariffDto> findAll() {
        return tariffMapper.convertToDtoList(tariffRepository.findAll());
    }

    @Override
    public TariffDtoWithoutId findTariffByNameWithPhones(String tariffName) {
        if (tariffName != null
                && tariffName.length() > 0) {
            return tariffMapper.convertToDtoWithoutId(tariffRepository.findTariffByName(tariffName));
        } else {
            throw new EntityNotCorrectException("Check input sources.");
        }
    }

    @Override
    public TariffDto findTariffByNameWithoutPhones(String tariffName) {
        if (tariffName != null
                && tariffName.length() > 0) {
            return tariffMapper.convertToDto(tariffRepository.findTariffByName(tariffName));
        } else {
            throw new EntityNotCorrectException("Check input sources.");
        }
    }

    @Override
    public List<TariffDto> sortTariffByPrice() {
        List<TariffDto> tariffDtoList = findAll();
        tariffDtoList.sort(Comparator.comparing(TariffDto::getPrice));
        return tariffDtoList;
    }

    @Override
    public TariffDto findByPriceAndMinutesAndMegabytes(Double priceFrom, Double priceTo, Integer minutesFrom, Integer minutesTo,
                                                       Integer megabytesFrom, Integer megabytesTo) {
        return tariffMapper.convertToDto(tariffRepository.findTariffByPriceBetweenAndMinutesBetweenAndMegabytesBetween(
                priceFrom, priceTo, minutesFrom, minutesTo, megabytesFrom, megabytesTo)
        );
    }
}
