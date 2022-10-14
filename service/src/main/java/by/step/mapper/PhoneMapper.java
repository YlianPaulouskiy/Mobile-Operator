package by.step.mapper;

import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import by.step.entity.Phone;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface PhoneMapper {

    Phone convert(PhoneDto phoneDto);

    Phone convert(PhoneDtoWithId phoneDtoWithId);

    Phone convert(PhoneClientDto phoneClientDto);

    PhoneDto convertToDto(Phone phone);

    PhoneDtoWithId convertToDtoWithId(Phone phone);

    PhoneClientDto convertToDtoWithClient(Phone phone);

    @AfterMapping
    default void linkTariff(@MappingTarget Phone phone) {
        if (phone != null && phone.getTariff() != null) {
            phone.getTariff().setPhone(phone);
        }
    }

    @AfterMapping
    default void linkPClient(@MappingTarget Phone phone) {
        if (phone != null && phone.getClient() != null && phone.getTariff() != null) {
            if (phone.getClient().getPhoneList() != null) {
                phone.getClient().getPhoneList().add(phone);
            }
        }
    }

}
