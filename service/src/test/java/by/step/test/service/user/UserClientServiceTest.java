package by.step.test.service.user;

import by.step.dto.clientDto.ClientDtoWithoutId;
import by.step.dto.phoneDto.PhoneDtoWithoutId;
import by.step.entity.Client;
import by.step.entity.Phone;
import by.step.mapper.ClientMapper;
import by.step.repository.ClientRepository;
import by.step.service.user.impl.UserClientServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private UserClientServiceImpl userClientService;

    private static ClientDtoWithoutId clientDtoWithoutId = new ClientDtoWithoutId();

    private static Client client = new Client();

    private static List<ClientDtoWithoutId> clientDtoWithoutIdList = new ArrayList<>();

    private static List<Client> clientList = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        client.setId(1L);
        client.setName("Name");
        client.setLastName("LastName");
        client.setPatronymic("Patronymic");
        Phone phone = new Phone();
        phone.setCountryCode("+375");
        phone.setOperatorCode("44");
        phone.setMobile("1234567");
        phone.setClient(client);
        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);
        client.setPhoneList(phoneList);

        clientList.add(client);

        clientDtoWithoutId.setName("Name");
        clientDtoWithoutId.setLastName("LastName");
        clientDtoWithoutId.setPatronymic("Patronymic");
        PhoneDtoWithoutId phoneDtoWithoutId = new PhoneDtoWithoutId();
        phoneDtoWithoutId.setCountryCode("+375");
        phoneDtoWithoutId.setOperatorCode("44");
        phoneDtoWithoutId.setMobile("1234567");
        phoneDtoWithoutId.setClient(clientDtoWithoutId);
        List<PhoneDtoWithoutId> phoneDtoWithoutIdList = new ArrayList<>();
        phoneDtoWithoutIdList.add(phoneDtoWithoutId);
        clientDtoWithoutId.setPhoneList(phoneDtoWithoutIdList);

        clientDtoWithoutIdList.add(clientDtoWithoutId);
    }

    @Test
    @DisplayName("Find client by Id")
    public void findOneByIdTest() {
        when(clientMapper.convertToDtoWithoutId(client)).thenReturn(clientDtoWithoutId);
        when(clientRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(client));

        assertAll(() -> {
            assertEquals(userClientService.findOneById(1L), clientDtoWithoutId);
            assertNotEquals(userClientService.findOneById(1L), client);
        });
    }

    @Test
    @DisplayName("Find client by Null Id")
    public void findOneByIdNullTest() {
        Long id = 0L;
        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            userClientService.findOneById(id);
        });

        assertAll(() -> {
            assertEquals("Client #0 not found.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Find All clients")
    public void findAllClientsTest() {
        when(clientMapper.convertToDtoListWithoutId(clientList)).thenReturn(clientDtoWithoutIdList);
        when(clientRepository.findAll()).thenReturn(clientList);

        assertAll(() -> {
            assertEquals(userClientService.findAll(), clientDtoWithoutIdList);
            assertNotEquals(userClientService.findAll(), clientList);
        });
    }

    @Test
    @DisplayName("find Amount clients")
    public void findAmountClientsTest() {
        when(clientRepository.count()).thenReturn(Long.valueOf(clientList.size()));

        assertAll(() -> {
            assertEquals(userClientService.getAmountClients(), 1L);
        });
    }


}
