package by.step.mapper;

import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.entity.Phone;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface PhoneMapper {

    Phone convert(PhoneDto phoneDto);

    Phone convert(PhoneDtoWithId phoneDtoWithId);

    Phone convert(PhoneClientDto phoneClientDto);

    Phone convert(PhoneDtoWithoutId phoneDtoWithoutId);

    PhoneDto convertToDto(Phone phone);

    PhoneDtoWithId convertToDtoWithId(Phone phone);

    PhoneClientDto convertToDtoWithClient(Phone phone);

    PhoneDtoWithoutId convertToDtoWithoutId(Phone phone);

    List<PhoneDtoWithoutId> convertToDtoListWithoutId(List<Phone> phoneList);

    List<PhoneClientDto> convertToPhoneClientDtoList(List<Phone> phoneList);

    @AfterMapping
    default void linkTariff(@MappingTarget Phone phone) {
        if (phone != null && phone.getTariff() != null
                && phone.getTariff().getPhoneList() != null) {
            phone.getTariff().getPhoneList().add(phone);
        }
    }

    @AfterMapping
    default void linkClient(@MappingTarget Phone phone) {
        if (phone != null && phone.getClient() != null
                && phone.getClient().getPhoneList() != null) {
            phone.getClient().getPhoneList().add(phone);
        }
    }

}
