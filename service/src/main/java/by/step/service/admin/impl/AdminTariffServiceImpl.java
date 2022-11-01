package by.step.service.admin.impl;

import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.entity.Client;
import by.step.entity.Phone;
import by.step.entity.Tariff;
import by.step.mapper.PhoneMapper;
import by.step.mapper.TariffMapper;
import by.step.repository.PhoneRepository;
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
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

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
    public TariffPhoneDto save(TariffDto entity) {
        if (entity != null) {
            if (!tariffRepository.existsByPriceAndMinutesAndMegabytes(
                    entity.getPrice(), entity.getMinutes(), entity.getMegabytes())) {
                if (entity.getPrice() > 0.0
                        && entity.getMinutes() > 0
                        && entity.getMegabytes() > 0) {
                    return tariffMapper.convertToDtoWithPhone(
                            tariffRepository.save(
                                    tariffMapper.convert(entity)
                            )
                    );
                } else {
                    throw new EntityNotCorrectException("Check input sources.");
                }
            } else {
                throw new EntityExistsException("Tariff with this parameters already exists.");
            }
        } else {
            throw new EntityNotCorrectException("Input sources is null.");
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
    public TariffPhoneDto findByPriceAndMinutesAndMegabytes(Double priceFrom, Double priceTo,
                                                            Integer minutesFrom, Integer minutesTo,
                                                            Integer megabytesFrom, Integer megabytesTo) {
        return tariffMapper.convertToDtoWithPhone(tariffRepository
                .findTariffByPriceBetweenAndMinutesBetweenAndMegabytesBetween(
                priceFrom, priceTo, minutesFrom, minutesTo, megabytesFrom, megabytesTo)
        );
    }

    @Override
    public TariffPhoneDto addPhoneById(Long tariffId, Long phoneId) {
        if (tariffRepository.existsById(tariffId) && phoneRepository.existsById(phoneId)) {
            Tariff tariff = tariffMapper.convert(findOneById(tariffId));
            Phone phone = phoneRepository.findById(phoneId).get();
            if (phone.getTariff() == null
                    || !phone.getTariff().getId().equals(tariffId)) {
                tariff.getPhoneList().add(phone);
                phone.setTariff(tariff);
                tariffRepository.save(tariff);
                phoneRepository.save(phone);
                return tariffMapper.convertToDtoWithPhone(tariff);
            } else {
                throw new EntityExistsException("Tariff already exist this phone.");
            }
        } else {
            throw new EntityNotFoundException("Tariff id " + tariffId + " or phone id " + phoneId + " doesn't exist.");
        }
    }

    @Override
    public TariffPhoneDto addPhoneByNumber(Long tariffId, PhoneDto phoneDto) {
        if (tariffRepository.existsById(tariffId)) {
            if (phoneDto.getCountryCode().length() != 0
                    && phoneDto.getOperatorCode().length() != 0
                    && phoneDto.getMobile().length() != 0) {
                if (phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
                        phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile())) {
                    Phone phone = phoneRepository.findByCountryCodeAndOperatorCodeAndMobile(
                            phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile());
                    return addPhoneById(tariffId, phone.getId());
                } else {
                    Phone phone = phoneMapper.convert(phoneDto);
                    phone = phoneRepository.save(phone);
                    return addPhoneById(tariffId, phone.getId());
                }
            } else {
                throw new EntityNotCorrectException("Check input sources.");
            }
        } else {
            throw new EntityNotFoundException("Tariff id# " + tariffId + " not found.");
        }
    }
}
