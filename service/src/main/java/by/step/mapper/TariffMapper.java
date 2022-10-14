package by.step.mapper;

import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffDtoWithId;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.entity.Tariff;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface TariffMapper {

    Tariff convert(TariffDto tariffDto);

    Tariff convert(TariffDtoWithId tariffDtoWithId);

    Tariff convert(TariffPhoneDto tariffPhoneDto);

    TariffDto convertToDto(Tariff tariff);

    TariffDtoWithId convertToDtoWithId(Tariff tariff);

    TariffPhoneDto convertToDtoWithPhone(Tariff tariff);

    @AfterMapping
    default void linkPhone(@MappingTarget Tariff tariff) {
        if (tariff != null && tariff.getPhone() != null) {
            tariff.getPhone().setTariff(tariff);
        }
    }

}
