package by.step.mapper;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffDtoWithoutId;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.entity.Tariff;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface TariffMapper {

    Tariff convert(TariffDto tariffDto);

    Tariff convert(TariffDtoWithId tariffDtoWithId);

    Tariff convert(TariffPhoneDto tariffPhoneDto);

    Tariff convert(TariffDtoWithoutId tariffDtoWithoutId);

    TariffDto convertToDto(Tariff tariff);

    TariffDtoWithId convertToDtoWithId(Tariff tariff);

    TariffPhoneDto convertToDtoWithPhone(Tariff tariff);

    TariffDtoWithoutId convertToDtoWithoutId(Tariff tariff);

    List<TariffDtoWithoutId> convertToDtoListWithoutId(List<Tariff> tariffList);

    List<TariffDto> convertToDto(List<TariffDtoWithoutId> tariffDtoWithoutIds);

    List<TariffPhoneDto> convertToTariffPhoneDtoList(List<Tariff> tariffList);

    @AfterMapping
    default void linkPhone(@MappingTarget Tariff tariff) {
        if (tariff != null && tariff.getPhoneList() != null) {
            tariff.getPhoneList().forEach(phone -> phone.setTariff(tariff));
        }
    }

}
