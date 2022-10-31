//package by.step.test.service.user;
//
//import by.step.dto.clientDto.ClientDto;
//import by.step.dto.clientDto.ClientDtoWithoutId;
//import by.step.dto.phoneDto.PhoneDto;
//import by.step.entity.Client;
//import by.step.entity.Phone;
//import by.step.mapper.ClientMapper;
//import by.step.repository.ClientRepository;
//import by.step.service.user.impl.UserClientServiceImpl;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserClientServiceTest {
//
//    @Mock
//    private ClientRepository clientRepository;
//
//    @Mock
//    private ClientMapper clientMapper;
//
//    @InjectMocks
//    private UserClientServiceImpl userClientService;
//
//    private static ClientDtoWithoutId clientDtoWithoutId = new ClientDtoWithoutId();
//
//    private static ClientDto clientDto = new ClientDto();
//
//    private static Client client = new Client();
//
//    private static List<ClientDtoWithoutId> clientDtoWithoutIdList = new ArrayList<>();
//
//    private static List<Client> clientList = new ArrayList<>();
//
//
//    @BeforeAll
//    public static void setup() {
//        client.setId(1L);
//        client.setName("Name");
//        client.setLastName("LastName");
//        client.setPatronymic("Patronymic");
//        Phone phone = new Phone();
//        phone.setCountryCode("+375");
//        phone.setOperatorCode("44");
//        phone.setMobile("1234567");
//        phone.setClient(client);
//        List<Phone> phoneList = new ArrayList<>();
//        phoneList.add(phone);
//        client.setPhoneList(phoneList);
//
//        clientList.add(client);
//
//        clientDto.setName("Name");
//        clientDto.setLastName("LastName");
//        clientDto.setPatronymic("Patronymic");
//
//        clientDtoWithoutId.setName("Name");
//        clientDtoWithoutId.setLastName("LastName");
//        clientDtoWithoutId.setPatronymic("Patronymic");
//        PhoneDto phoneDto = new PhoneDto();
//        phoneDto.setCountryCode("+375");
//        phoneDto.setOperatorCode("44");
//        phoneDto.setMobile("1234567");
//        List<PhoneDto> phoneDtoList = new ArrayList<>();
//        phoneDtoList.add(phoneDto);
//        clientDtoWithoutId.setPhoneList(phoneDtoList);
//
//        clientDtoWithoutIdList.add(clientDtoWithoutId);
//
//    }
//
//    @Test
//    @DisplayName("Find Client By Name Test")
//    public void findOneByNameTest() {
//        when(clientMapper.convertToDtoWithoutId(client)).thenReturn(clientDtoWithoutId);
//        when(clientRepository.existsByNameAndLastNameAndPatronymic(clientDto.getName(),
//                clientDto.getLastName(), clientDto.getPatronymic())).thenReturn(true);
//        when(clientRepository.findByNameAndLastNameAndPatronymic(clientDto.getName(),
//                clientDto.getLastName(), clientDto.getPatronymic())).thenReturn(client);
//        assertAll(() -> {
//            assertEquals(userClientService.findOneByName(clientDto), clientDtoWithoutId);
//        });
//    }
//
//    @Test
//    @DisplayName("Find Client By Null Name Test")
//    public void findOneByNullNameTest() {
//        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
//            userClientService.findOneByName(null);
//        });
//
//        assertAll(() -> {
//            assertEquals("Client  not found.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Find All Clients Test")
//    public void findAllClientsTest() {
//        when(clientMapper.convertToDtoListWithoutId(clientList)).thenReturn(clientDtoWithoutIdList);
//        when(clientRepository.findAll()).thenReturn(clientList);
//
//        assertAll(() -> {
//            assertEquals(userClientService.findAll(), clientDtoWithoutIdList);
//            assertNotEquals(userClientService.findAll(), clientList);
//        });
//    }
//
//    @Test
//    @DisplayName("Find Amount Clients Test")
//    public void findAmountClientsTest() {
//        when(clientRepository.count()).thenReturn(Long.valueOf(clientList.size()));
//
//        assertAll(() -> {
//            assertEquals(userClientService.getAmountClients(), clientDtoWithoutIdList.size());
//        });
//    }
//
//}
