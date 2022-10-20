package by.step.mapper;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.entity.Client;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ClientMapper {

    Client convert(ClientDto clientDto);

    Client convert(ClientDtoWithId clientDtoWithId);

    Client convert(ClientPhoneDto clientPhoneDto);

    Client convert(ClientDtoWithoutId clientDtoWithoutId);

    ClientDto convertToDto(Client client);

    ClientDtoWithId convertToDtoWithId(Client client);

    ClientPhoneDto convertToDtoWithPhone(Client client);

    ClientDtoWithoutId convertToDtoWithoutId(Client client);

    List<ClientDtoWithoutId> convertToDtoListWithoutId(List<Client> clientList);

    List<ClientPhoneDto> convertToClientPhoneDtoList(List<Client> clientList);

    @AfterMapping
    default void linkPhone(@MappingTarget Client client) {
        if (client != null && client.getPhoneList() != null) {
            client.getPhoneList().forEach(phone -> phone.setClient(client));
        }
    }
}
