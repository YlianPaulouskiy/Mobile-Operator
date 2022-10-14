package by.step.mapper;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.entity.Client;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ClientMapper {

    Client convert(ClientDto clientDto);

    Client convert(ClientDtoWithId clientDtoWithId);

    Client convert(ClientPhoneDto clientPhoneDto);

    ClientDto convertToDto(Client client);

    ClientDtoWithId convertToDtoWithId(Client client);

    ClientPhoneDto convertToDtoWithPhone(Client client);

    @AfterMapping
    default void linkPhone(@MappingTarget Client client) {
        if (client != null && client.getPhoneList() != null) {
            client.getPhoneList().forEach(phone -> phone.setClient(client));
        }
    }
}
