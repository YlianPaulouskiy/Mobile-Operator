package by.step.service.admin.impl;

import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.mapper.TariffMapper;
import by.step.repository.TariffRepository;
import by.step.service.admin.AdminTariffService;
import by.step.service.exception.EntityNotCorrectException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class AdminTariffServiceImpl implements AdminTariffService {

    private final TariffRepository tariffRepository;
    private final TariffMapper tariffMapper;

    @Override
    public TariffPhoneDto findOneById(Long id) {
        return tariffMapper.convertToDtoWithPhone(
                tariffRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException("Tariff id# " + id + " not found.")
                )
        );
    }

    @Override
    public List<TariffPhoneDto> findAll() {
        return tariffMapper.convertToTariffPhoneDtoList(tariffRepository.findAll());
    }

    @Override
    public TariffPhoneDto save(TariffPhoneDto entity) {
        if (!tariffRepository.existsByPriceAndMinutesAndMegabytes(
                entity.getPrice(), entity.getMinutes(), entity.getMegabytes())) {
            if (entity.getPrice() > 0.0
            && entity.getMinutes() > 0
            && entity.getMegabytes() > 0) {
                return tariffMapper.convertToDtoWithPhone(
                        tariffRepository.save (
                                tariffMapper.convert(entity)
                        )
                );
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityExistsException("Tariff with this parameters already exists");
        }
    }

    @Override
    public void removeById(Long id) {
        if (tariffRepository.existsById(id)) {
            tariffRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Tariff id# " + id + " not found.");
        }
    }

    @Override
    public List<TariffPhoneDto> sortTariffByPrice() {
        List<TariffPhoneDto> tariffPhoneDtoList = findAll();
        tariffPhoneDtoList.sort(Comparator.comparing(TariffPhoneDto::getPrice));
        return tariffPhoneDtoList;
    }

    @Override
    public TariffPhoneDto findByPriceAndMinutesAndMegabytes(Double priceFrom, Double priceTo, Integer minutesFrom, Integer minutesTo,
                                                       Integer megabytesFrom, Integer megabytesTo) {
        return tariffMapper.convertToDtoWithPhone(tariffRepository.findTariffByPriceBetweenAndMinutesBetweenAndMegabytesBetween(
                priceFrom, priceTo, minutesFrom, minutesTo, megabytesFrom, megabytesTo)
        );
    }
}
