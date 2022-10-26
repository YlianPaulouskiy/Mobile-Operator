package by.step.test.service.admin;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.entity.Client;
import by.step.entity.Phone;
import by.step.mapper.ClientMapper;
import by.step.mapper.PhoneMapper;
import by.step.repository.ClientRepository;
import by.step.repository.PhoneRepository;
import by.step.service.admin.impl.AdminClientServiceImpl;
import by.step.service.exception.EntityNotCorrectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private PhoneMapper phoneMapper;

    @InjectMocks
    private AdminClientServiceImpl adminClientService;

    private static Client client = new Client();

    private static ClientPhoneDto clientPhoneDto = new ClientPhoneDto();

    private static List<Client> clientList = new ArrayList<>();

    private static List<ClientPhoneDto> clientPhoneDtoList = new ArrayList<>();

    private static Phone phone = new Phone();

    private static PhoneClientDto phoneClientDto = new PhoneClientDto();

    private static PhoneDto phoneDto = new PhoneDto();

    @BeforeEach
    public void setup() {
        client.setId(1L);
        client.setName("Name");
        client.setLastName("LastName");
        client.setPatronymic("Patronymic");
        client.setPhoneList(new ArrayList<>());

        phone.setId(1L);
        phone.setCountryCode("+375");
        phone.setOperatorCode("44");
        phone.setMobile("1234567");

        clientList.add(client);

        clientPhoneDto.setId(1L);
        clientPhoneDto.setName("Name");
        clientPhoneDto.setLastName("LastName");
        clientPhoneDto.setPatronymic("Patronymic");
        clientPhoneDto.setPhoneList(new ArrayList<>());

        phoneClientDto.setId(1L);
        phoneClientDto.setCountryCode("+375");
        phoneClientDto.setOperatorCode("44");
        phoneClientDto.setMobile("1234567");

        clientPhoneDtoList.add(clientPhoneDto);

        phoneDto.setCountryCode("+375");
        phoneDto.setOperatorCode("44");
        phoneDto.setMobile("1234567");

    }

    @Test
    @DisplayName("Find client by Id Test")
    public void findOneByIdTest() {
        when(clientMapper.convertToDtoWithPhone(client)).thenReturn(clientPhoneDto);
        when(clientRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(client));

        assertAll(() -> {
            assertEquals(adminClientService.findOneById(1L), clientPhoneDto);
            assertNotEquals(adminClientService.findOneById(1L), client);
        });
    }

    @Test
    @DisplayName("Find client by Null Id Test")
    public void findOneByIdNullTest() {
        Long id = 0L;
        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            adminClientService.findOneById(id);
        });

        assertAll(() -> {
            assertEquals("Client id# 0 not found.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Find All Clients Test")
    public void findAllClientsTest() {
        when(clientMapper.convertToClientPhoneDtoList(clientList)).thenReturn(clientPhoneDtoList);
        when(clientRepository.findAll()).thenReturn(clientList);

        assertAll(() -> {
            assertEquals(adminClientService.findAll(), clientPhoneDtoList);
            assertNotEquals(adminClientService.findAll(), clientList);
        });
    }

    @Test
    @DisplayName("Save Test")
    public void saveTest() {
        when(clientMapper.convertToDtoWithPhone(ArgumentMatchers.any(Client.class))).thenReturn(clientPhoneDto);
        when(clientRepository.save(ArgumentMatchers.any(Client.class))).thenReturn(client);
        when(clientMapper.convert(ArgumentMatchers.any(ClientPhoneDto.class))).thenReturn(client);
        when(clientRepository.existsByNameAndLastNameAndPatronymic(ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(true);

        assertAll(() -> {
            assertEquals(adminClientService.save(clientPhoneDto), clientPhoneDto);
        });
    }

    @Test
    @DisplayName("Save Exists Exception Text")
    public void saveExistsExceptionTest() {
        Throwable exception = assertThrows(EntityExistsException.class, () -> {
            adminClientService.save(clientPhoneDto);
        });
        assertAll(() -> {
            assertEquals("Client already exists.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Save Incorrect Data Exception Test")
    public void saveIncorrectDataExceptionTest() {
        when(clientRepository.existsByNameAndLastNameAndPatronymic(ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(true);
        clientPhoneDto.setName("");
        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
            adminClientService.save(clientPhoneDto);
        });
        assertAll(() -> {
            assertEquals("Check input sources.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Save Null Client Test")
    public void saveNullClientTest() {
        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
            adminClientService.save(null);
        });
        assertAll(() -> {
            assertEquals("Input source is null.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Remove Client Test")
    public void removeTest() {
        when(clientRepository.existsById(1L)).thenReturn(true);
        adminClientService.removeById(1L);
        verify(clientRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Remove Exception Tariff Test")
    public void removeExceptionTest() {
        when(clientRepository.existsById(1L)).thenReturn(false);

        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            adminClientService.removeById(1L);
        });

        assertAll(() -> {
            assertEquals("Client id# " + 1L + " not found.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Add Phone(exist) To Client Test")
    public void addExistPhoneToClientTest() {
        when(clientRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        when(phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
                ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())
        ).thenReturn(true);
        when(phoneRepository.findByCountryCodeAndOperatorCodeAndMobile(
                ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())
        ).thenReturn(phone);
        //addPhoneToClient(Long clientId, Long phoneId)
        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
        when(phoneRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(phone));
        when(clientMapper.convert(clientPhoneDto)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(client);
        when(phoneMapper.convert(phoneClientDto)).thenReturn(phone);
        when(phoneRepository.save(phone)).thenReturn(phone);
        //findOneById
        when(clientMapper.convertToDtoWithPhone(client)).thenReturn(clientPhoneDto);
        when(clientRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(client));

        assertAll(() -> {
            assertNotNull(adminClientService.addPhoneToClient(clientPhoneDto.getId(), phoneDto));
        });
    }

    @Test
    @DisplayName("Add Not Exist Phone By Id To Client Test")
    public void addNotExistPhoneToClientTest() {
        when(clientRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        when(phoneMapper.convert(phoneDto)).thenReturn(phone);
        //addPhoneToClient(Long clientId, Long phoneId)
        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
        when(phoneRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(phone));
        when(clientMapper.convert(clientPhoneDto)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(client);
        when(phoneMapper.convert(phoneClientDto)).thenReturn(phone);
        when(phoneRepository.save(phone)).thenReturn(phone);
        //findOneById
        when(clientMapper.convertToDtoWithPhone(client)).thenReturn(clientPhoneDto);
        when(clientRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(client));

        assertAll(() -> {
            assertNotNull(adminClientService.addPhoneToClient(clientPhoneDto.getId(), phoneDto));
        });
    }

    @Test
    @DisplayName("Add Phone To Client Exception Test")
    public void addPhoneToClientExceptionTest() {
        when(clientRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(false);

        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            adminClientService.addPhoneToClient(clientPhoneDto.getId(), phoneDto);
        });

        assertAll(() -> {
            assertEquals("Client id# " + clientPhoneDto.getId() + " not found.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Add Phone To Client Input Exception Test")
    public void addPhoneToClientInputExceptionTest() {
        when(clientRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
        phoneDto.setMobile("123");

        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
            adminClientService.addPhoneToClient(clientPhoneDto.getId(), phoneDto);
        });

        assertAll(() -> {
            assertEquals("Check input sources.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Find Amount Clients Test")
    public void findAmountClientsTest() {
        when(clientRepository.count()).thenReturn(Long.valueOf(clientList.size()));

        assertAll(() -> {
            assertEquals(adminClientService.getAmountClients(), clientPhoneDtoList.size());
        });
    }

}
