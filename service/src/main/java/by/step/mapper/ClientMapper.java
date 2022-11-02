package by.step.mapper;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.entity.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ClientMapper {

    Client convert(ClientDto clientDto);

    Client convert(ClientDtoWithId clientDtoWithId);

    Client convert(ClientPhoneDto clientPhoneDto);

    Client convert(ClientDtoWithoutId clientDtoWithoutId);

    @Named(value = "convertToDto")
    ClientDto convertToDto(Client client);

    @Named(value = "convertToDtoWithId")
    ClientDtoWithId convertToDtoWithId(Client client);

    ClientPhoneDto convertToDtoWithPhone(Client client);

    ClientDtoWithoutId convertToDtoWithoutId(Client client);

    @IterableMapping(qualifiedByName = "convertToDto")
    List<ClientDto> convertToDtoList(List<Client> clientList);

    @IterableMapping(qualifiedByName = "convertToDtoWithId")
    List<ClientDtoWithId> convertToClientDto(List<Client> clientList);

    @AfterMapping
    default void linkPhone(@MappingTarget Client client) {
        if (client != null && client.getPhoneList() != null) {
            client.getPhoneList().forEach(phone -> phone.setClient(client));
        }
    }
}
