package by.step.mapper;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client convert(ClientDto clientDto);

    Client convert(ClientDtoWithId clientDtoWithId);

    Client convert(ClientPhoneDto clientPhoneDto);

    ClientDto convertToDto(Client client);

    ClientDtoWithId convertToDtoWithId(Client client);

    ClientPhoneDto convertToDtoWithPhone(Client client);

}
