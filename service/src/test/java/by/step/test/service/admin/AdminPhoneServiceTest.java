//package by.step.test.service.admin;
//
//import by.step.dto.clientDto.ClientDto;
//import by.step.dto.clientDto.ClientPhoneDto;
//import by.step.dto.phoneDto.PhoneClientDto;
//import by.step.dto.tariffDto.TariffPhoneDto;
//import by.step.entity.Client;
//import by.step.entity.Phone;
//import by.step.entity.Tariff;
//import by.step.mapper.ClientMapper;
//import by.step.mapper.PhoneMapper;
//import by.step.mapper.TariffMapper;
//import by.step.repository.ClientRepository;
//import by.step.repository.PhoneRepository;
//import by.step.repository.TariffRepository;
//import by.step.service.admin.impl.AdminPhoneServiceImpl;
//import by.step.service.exception.EntityNotCorrectException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.persistence.EntityExistsException;
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class AdminPhoneServiceTest {
//
//    @Mock
//    private PhoneRepository phoneRepository;
//
//    @Mock
//    private PhoneMapper phoneMapper;
//
//    @Mock
//    private ClientRepository clientRepository;
//
//    @Mock
//    private TariffRepository tariffRepository;
//
//    @Mock
//    private TariffMapper tariffMapper;
//
//    @InjectMocks
//    private AdminPhoneServiceImpl adminPhoneService;
//
//    private static Phone phone = new Phone();
//
//    private static PhoneClientDto phoneClientDto = new PhoneClientDto();
//
//    private static List<Phone> phoneList = new ArrayList<>();
//
//    private static List<PhoneClientDto> phoneClientDtoList = new ArrayList<>();
//
//    private static Client client = new Client();
//
//    private static ClientDto clientDto = new ClientDto();
//
//    private static ClientPhoneDto clientPhoneDto = new ClientPhoneDto();
//
//    private static Tariff tariff = new Tariff();
//
//    private static TariffPhoneDto tariffPhoneDto = new TariffPhoneDto();
//
//    @BeforeEach
//    public void setup() {
//        phone.setId(1L);
//        phone.setCountryCode("+375");
//        phone.setOperatorCode("44");
//        phone.setMobile("1234567");
//
//        phoneList.add(phone);
//
//        phoneClientDto.setId(1L);
//        phoneClientDto.setCountryCode("+375");
//        phoneClientDto.setOperatorCode("44");
//        phoneClientDto.setMobile("1234567");
//
//        phoneClientDtoList.add(phoneClientDto);
//
//        client.setId(1L);
//        client.setName("Name");
//        client.setLastName("LastName");
//        client.setPatronymic("Patronymic");
//        client.setPhoneList(new ArrayList<>());
//
//        clientDto.setName("Name");
//        clientDto.setLastName("LastName");
//        clientDto.setPatronymic("Patronymic");
//
//        clientPhoneDto.setId(1L);
//        clientPhoneDto.setName("Name");
//        clientPhoneDto.setLastName("LastName");
//        clientPhoneDto.setPatronymic("Patronymic");
//        clientPhoneDto.setPhoneList(new ArrayList<>());
//
//        tariff.setId(1L);
//        tariff.setName("Tariff1");
//        tariff.setMinutes(100);
//        tariff.setMegabytes(100);
//        tariff.setPrice(10.0);
//        tariff.setPhoneList(new ArrayList<>());
//
//        tariffPhoneDto.setId(1L);
//        tariffPhoneDto.setName("Tariff1");
//        tariffPhoneDto.setMinutes(100);
//        tariffPhoneDto.setMegabytes(100);
//        tariffPhoneDto.setPrice(10.0);
//        tariffPhoneDto.setPhoneList(new ArrayList<>());
//    }
//
//    @Test
//    @DisplayName("Find One Phone By Id Test")
//    public void findOneByIdTest() {
//        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
//        when(phoneRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(phone));
//
//        assertAll(() -> {
//            assertEquals(adminPhoneService.findOneById(1L), phoneClientDto);
//            assertNotEquals(adminPhoneService.findOneById(1L), phone);
//        });
//    }
//
//    @Test
//    @DisplayName("Find One Phone By Null Id Test")
//    public void findOneByIdNullTest() {
//        Long id = 0L;
//        Throwable exception = assertThrows(EntityNotFoundException.class,
//                () -> adminPhoneService.findOneById(id)
//        );
//
//        assertAll(() -> {
//            assertEquals("Phone id# 0 not found.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Find All Phones Test")
//    public void findAllTest() {
//        when(phoneMapper.convertToPhoneClientDtoList(phoneList)).thenReturn(phoneClientDtoList);
//        when(phoneRepository.findAll()).thenReturn(phoneList);
//
//        assertAll(() -> {
//            assertEquals(adminPhoneService.findAll(), phoneClientDtoList);
//            assertNotEquals(adminPhoneService.findAll(), phoneList);
//        });
//    }
//
//    @Test
//    @DisplayName("Save Test")
//    public void saveTest() {
//        when(phoneMapper.convertToDtoWithClient(ArgumentMatchers.any(Phone.class))).thenReturn(phoneClientDto);
//        when(phoneRepository.save(ArgumentMatchers.any(Phone.class))).thenReturn(phone);
//        when(phoneMapper.convert(ArgumentMatchers.any(PhoneClientDto.class))).thenReturn(phone);
//
//        assertAll(() -> {
//            assertEquals(adminPhoneService.save(phoneClientDto), phoneClientDto);
//        });
//    }
//
//    @Test
//    @DisplayName("Save Exists Exception Text")
//    public void saveExistsExceptionTest() {
//        when(phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(ArgumentMatchers.anyString(),
//                ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(true);
//        Throwable exception = assertThrows(EntityExistsException.class, () -> {
//            adminPhoneService.save(phoneClientDto);
//        });
//
//        assertAll(() -> {
//            assertEquals("This phone already exists.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Save Incorrect Data Exception Test")
//    public void saveIncorrectDataExceptionTest() {
//        phoneClientDto.setMobile("");
//        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
//            adminPhoneService.save(phoneClientDto);
//        });
//
//        assertAll(() -> {
//            assertEquals("Check input sources.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Save Null Phone Test")
//    public void saveNullPhoneTest() {
//        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
//            adminPhoneService.save(null);
//        });
//
//        assertAll(() -> {
//            assertEquals("Input sources is null.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Remove Phone Test")
//    public void removeTest() {
//        when(phoneRepository.existsById(1L)).thenReturn(true);
//        adminPhoneService.removeById(1L);
//        verify(phoneRepository).deleteById(1L);
//    }
//
//    @Test
//    @DisplayName("Remove Exception Phone Test")
//    public void removeExceptionTest() {
//        when(phoneRepository.existsById(1L)).thenReturn(false);
//
//        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
//            adminPhoneService.removeById(1L);
//        });
//
//        assertAll(() -> {
//            assertEquals("Phone id# " + 1L + " not found.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Add Phone(exist) To Client Test")
//    public void addExistPhoneToClientTest() {
//        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        when(clientRepository.existsByNameAndLastNameAndPatronymic(
//                ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())
//        ).thenReturn(true);
//        when(clientRepository.findByNameAndLastNameAndPatronymic(
//                ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())
//        ).thenReturn(client);
//        //addPhoneToClient(Long clientId, Long phoneId)
//        when(clientRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        when(phoneMapper.convert(phoneClientDto)).thenReturn(phone);
//        when(clientRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(client));
//        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
//        //findOneById
//        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
//        when(phoneRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(phone));
//
//        assertAll(() -> {
//            assertNotNull(adminPhoneService.addClientByName(phoneClientDto.getId(), clientDto));
//        });
//    }
//
//    @Test
//    @DisplayName("Add Tariff To Phone Test")
//    public void addTariffToPhoneTest() {
//        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        when(tariffRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        when(phoneMapper.convert(phoneClientDto)).thenReturn(phone);
//        when(tariffRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(tariff));
//        //findOneById
//        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
//        when(phoneRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(phone));
//
//        assertAll(() -> {
//            assertNotNull(adminPhoneService.addTariffById(phone.getId(), tariff.getId()));
//        });
//    }
//
//    @Test
//    @DisplayName("Add Client To Phone Exception Test")
//    public void addClientToPhoneExceptionTest() {
//        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(false);
//
//        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
//            adminPhoneService.addClientByName(phoneClientDto.getId(), clientDto);
//        });
//
//        assertAll(() -> {
//            assertEquals("Phone id " + phoneClientDto.getId() + " doesn't exist.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Add Client To Phone Input Exception Test")
//    public void addClientToPhoneInputExceptionTest() {
//        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        clientDto.setName("");
//
//        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
//            adminPhoneService.addClientByName(clientPhoneDto.getId(), clientDto);
//        });
//
//        assertAll(() -> {
//            assertEquals("Check input sources.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Add Client To Phone Exception Test")
//    public void addTariffToPhoneExceptionTest() {
//        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(false);
//
//        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
//            adminPhoneService.addTariffById(phoneClientDto.getId(), tariffPhoneDto.getId());
//        });
//
//        assertAll(() -> {
//            assertEquals("Tariff id " + tariffPhoneDto.getId() + " or phone id " + phoneClientDto.getId() + " doesn't exist.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Add Tariff To Phone Input Exception Test")
//    public void addTariffToPhoneInputExceptionTest() {
//        when(phoneRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        when(tariffRepository.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
//        when(phoneMapper.convert(phoneClientDto)).thenReturn(phone);
//        when(tariffRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(tariff));
//        //findOneById
//        when(phoneMapper.convertToDtoWithClient(phone)).thenReturn(phoneClientDto);
//        when(phoneRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(phone));
//        phone.setTariff(tariff);
//
//        Throwable exception = assertThrows(EntityExistsException.class, () -> {
//            adminPhoneService.addTariffById(clientPhoneDto.getId(), tariffPhoneDto.getId());
//        });
//
//        assertAll(() -> {
//            assertEquals("Phone already used this tariff.", exception.getMessage());
//        });
//    }
//
//}
