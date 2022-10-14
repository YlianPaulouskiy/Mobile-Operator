package by.step.test.mapper;

import by.step.dto.clientDto.ClientDto;
import by.step.dto.clientDto.ClientDtoWithId;
import by.step.dto.clientDto.ClientPhoneDto;
import by.step.entity.Client;
import by.step.entity.Phone;
import by.step.mapper.ClientMapper;
import by.step.mapper.ClientMapperImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ClientMapperTest {

    @Mock
    private final ClientMapper clientMapper = new ClientMapperImpl();

    private Client client = new Client();
    private ClientDto clientDto;
    private ClientDtoWithId clientDtoWithId;
    private ClientPhoneDto clientPhoneDto;

    @Before
    public void setClient() {
        client.setId(1L);
        client.setName("Name");
        client.setLastName("LastName");
        client.setPatronymic("Patronymic");
        client.setDateCreation(new Date());
        client.setLastModified(new Date());
        client.setVersion(1L);
        Phone firstPhone = new Phone();
        Phone secondPhone = new Phone();
        List<Phone> phoneList = new ArrayList<>();
        Collections.addAll(phoneList, firstPhone, secondPhone);
        client.setPhoneList(phoneList);
    }

    @Test
    @DisplayName("Convert Client to ClientDto Test")
    public void convertToClientDtoTest() {
        clientDto = clientMapper.convertToDto(client);
        assertThat(client.getName()).isEqualTo(clientDto.getName());
        assertThat(client.getLastName()).isEqualTo(clientDto.getLastName());
        assertThat(client.getPatronymic()).isEqualTo(clientDto.getPatronymic());
    }

    @Test
    @DisplayName("Convert Client to ClientDtoWithId Test")
    public void convertToClientDtoWithIdTest() {
        clientDtoWithId = clientMapper.convertToDtoWithId(client);
        assertThat(client.getName()).isEqualTo(clientDtoWithId.getName());
        assertThat(client.getLastName()).isEqualTo(clientDtoWithId.getLastName());
        assertThat(client.getPatronymic()).isEqualTo(clientDtoWithId.getPatronymic());
        assertThat(client.getId()).isEqualTo(clientDtoWithId.getId());
        assertThat(new SimpleDateFormat().format(client.getDateCreation())).isEqualTo(clientDtoWithId.getDateCreation());
        assertThat(new SimpleDateFormat().format(client.getLastModified())).isEqualTo(clientDtoWithId.getLastModified());
        assertThat(client.getVersion()).isEqualTo(clientDtoWithId.getVersion());
    }

    @Test
    @DisplayName("Convert Client to ClientPhoneDto Test")
    public void convertToClientPhoneDtoTest() {
        clientPhoneDto = clientMapper.convertToDtoWithPhone(client);
        assertThat(client.getName()).isEqualTo(clientPhoneDto.getName());
        assertThat(client.getLastName()).isEqualTo(clientPhoneDto.getLastName());
        assertThat(client.getPatronymic()).isEqualTo(clientPhoneDto.getPatronymic());
        assertThat(client.getId()).isEqualTo(clientPhoneDto.getId());
        assertThat(new SimpleDateFormat().format(client.getDateCreation())).isEqualTo(clientPhoneDto.getDateCreation());
        assertThat(new SimpleDateFormat().format(client.getLastModified())).isEqualTo(clientPhoneDto.getLastModified());
        assertThat(client.getVersion()).isEqualTo(clientPhoneDto.getVersion());
        assertThat(client.getPhoneList().size()).isEqualTo(clientPhoneDto.getPhoneList().size());
    }

    @Test
    @DisplayName("Convert to Client from ClientDto")
    public void convertToClientFromDtoTest() {
        clientDto = clientMapper.convertToDto(client);
        client = clientMapper.convert(clientDto);
        assertThat(clientDto.getName()).isEqualTo(client.getName());
        assertThat(clientDto.getLastName()).isEqualTo(client.getLastName());
        assertThat(clientDto.getPatronymic()).isEqualTo(client.getPatronymic());
    }

    @Test
    @DisplayName("Convert to Client from ClientDtoWithId")
    public void convertToClientFromDtoWithIdTest() {
        clientDtoWithId = clientMapper.convertToDtoWithId(client);
        client = clientMapper.convert(clientDtoWithId);
        assertThat(clientDtoWithId.getName()).isEqualTo(client.getName());
        assertThat(clientDtoWithId.getLastName()).isEqualTo(client.getLastName());
        assertThat(clientDtoWithId.getPatronymic()).isEqualTo(client.getPatronymic());
        assertThat(clientDtoWithId.getId()).isEqualTo(client.getId());
        assertThat(clientDtoWithId.getDateCreation()).isEqualTo(new SimpleDateFormat().format(client.getDateCreation()));
        assertThat(clientDtoWithId.getLastModified()).isEqualTo(new SimpleDateFormat().format(client.getLastModified()));
        assertThat(clientDtoWithId.getVersion()).isEqualTo(client.getVersion());
    }

    @Test
    @DisplayName("Convert to Client from ClientPhoneDto")
    public void convertToClientFromClientPhoneDtoTest() {
        clientPhoneDto = clientMapper.convertToDtoWithPhone(client);
        client = clientMapper.convert(clientPhoneDto);
        assertThat(clientPhoneDto.getName()).isEqualTo(client.getName());
        assertThat(clientPhoneDto.getLastName()).isEqualTo(client.getLastName());
        assertThat(clientPhoneDto.getPatronymic()).isEqualTo(client.getPatronymic());
        assertThat(clientPhoneDto.getId()).isEqualTo(client.getId());
        assertThat(clientPhoneDto.getDateCreation()).isEqualTo(new SimpleDateFormat().format(client.getDateCreation()));
        assertThat(clientPhoneDto.getLastModified()).isEqualTo(new SimpleDateFormat().format(client.getLastModified()));
        assertThat(clientPhoneDto.getVersion()).isEqualTo(client.getVersion());
        assertThat(clientPhoneDto.getPhoneList().size()).isEqualTo(client.getPhoneList().size());
    }

}
