package by.step.mapper;

import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.entity.Phone;
import org.mapstruct.*;

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

    @Named(value = "convertToDto")
    PhoneDto convertToDto(Phone phone);

    @Named(value = "convertToDtoWithId")
    PhoneDtoWithId convertToDtoWithId(Phone phone);

    PhoneClientDto convertToDtoWithClient(Phone phone);

    PhoneDtoWithoutId convertToDtoWithoutId(Phone phone);

    List<PhoneDtoWithoutId> convertToDtoListWithoutId(List<Phone> phoneList);

    @IterableMapping(qualifiedByName = "convertToDto")
    List<PhoneDto> convertToDtoList(List<Phone> phoneList);

    @IterableMapping(qualifiedByName = "convertToDtoWithId")
    List<PhoneDtoWithId> convertToDtoWithIdList(List<Phone> phoneList);

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
