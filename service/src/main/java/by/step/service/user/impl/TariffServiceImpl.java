package by.step.service.user.impl;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.mapper.TariffMapper;
import by.step.repository.TariffRepository;
import by.step.service.user.TariffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;

    @Override
    public TariffDtoWithoutId findOneById(Long id) {
        return tariffMapper.convertToDtoWithoutId(
                tariffRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Tariff #" + id + " not found.")
                )
        );
    }

    @Override
    public List<TariffDtoWithoutId> findAll() {
        return tariffMapper.convertToDtoListWithoutId(tariffRepository.findAll());
    }

    @Override
    public List<TariffDto> sortTariffByPrice() {
        List<TariffDto> tariffDtoList = tariffMapper.convertToDto(findAll());
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
