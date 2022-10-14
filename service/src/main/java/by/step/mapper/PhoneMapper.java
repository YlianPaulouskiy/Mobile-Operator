package by.step.mapper;

import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.dto.phoneDto.PhoneDtoWithId;
import by.step.entity.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone convert(PhoneDto phoneDto);

    Phone convert(PhoneDtoWithId phoneDtoWithId);

    Phone convert(PhoneClientDto phoneClientDto);

    PhoneDto convertToDto(Phone phone);

    PhoneDtoWithId convertToDtoWithId(Phone phone);

    PhoneClientDto convertToDtoWithPhones(Phone phone);

}
