//package by.step.test.service.user;
//
//import by.step.dto.clientDto.ClientDto;
//import by.step.dto.clientDto.ClientDtoWithoutId;
//import by.step.dto.phoneDto.PhoneDto;
//import by.step.dto.phoneDto.PhoneDtoWithoutId;
//import by.step.dto.tariffDto.TariffDto;
//import by.step.dto.tariffDto.TariffDtoWithoutId;
//import by.step.entity.Client;
//import by.step.entity.Phone;
//import by.step.entity.Tariff;
//import by.step.mapper.PhoneMapper;
//import by.step.repository.PhoneRepository;
//import by.step.service.user.impl.UserPhoneServiceImpl;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.persistence.EntityNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class UserPhoneServiceTest {
//
//    @Mock
//    private PhoneRepository phoneRepository;
//
//    @Mock
//    private PhoneMapper phoneMapper;
//
//    @InjectMocks
//    private UserPhoneServiceImpl userPhoneService;
//
//    private static Phone phone = new Phone();
//
//    private static PhoneDto phoneDto = new PhoneDto();
//
//    private static PhoneDtoWithoutId phoneDtoWithoutId = new PhoneDtoWithoutId();
//
//    private static List<Phone> phoneList = new ArrayList<>();
//
//    private static List<PhoneDtoWithoutId> phoneDtoWithoutIdList = new ArrayList<>();
//
//    @BeforeAll
//    public static void setup() {
//        phone.setId(1L);
//        phone.setCountryCode("+375");
//        phone.setOperatorCode("44");
//        phone.setMobile("1234567");
//        phone.setClient(new Client());
//        phone.setTariff(new Tariff());
//        phoneList.add(phone);
//
//        phoneDto.setCountryCode("+375");
//        phoneDto.setOperatorCode("44");
//        phoneDto.setMobile("1234567");
//
//        phoneDtoWithoutId.setCountryCode("+375");
//        phoneDtoWithoutId.setOperatorCode("44");
//        phoneDtoWithoutId.setMobile("1234567");
//        phoneDtoWithoutId.setClient(new ClientDto());
//        phoneDtoWithoutId.setTariff(new TariffDto());
//        phoneDtoWithoutIdList.add(phoneDtoWithoutId);
//    }
//
//    @Test
//    @DisplayName("Find One Phone By Number Test")
//    public void findOneByNumberTest() {
//        when(phoneMapper.convertToDtoWithoutId(phone)).thenReturn(phoneDtoWithoutId);
//        when(phoneRepository.existsByCountryCodeAndOperatorCodeAndMobile(
//                phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile()
//        )).thenReturn(true);
//        when(phoneRepository.findByCountryCodeAndOperatorCodeAndMobile(
//                phoneDto.getCountryCode(), phoneDto.getOperatorCode(), phoneDto.getMobile()
//        )).thenReturn(phone);
//
//        assertAll(() -> {
//            assertEquals(userPhoneService.findOneByNumber(phoneDto), phoneDtoWithoutId);
//        });
//    }
//
//    @Test
//    @DisplayName("Find One Phone By Null Id Test")
//    public void findOneByIdNullTest() {
//        Throwable exception = assertThrows(EntityNotFoundException.class,
//                () -> userPhoneService.findOneByNumber(null)
//        );
//
//        assertAll( () -> {
//            assertEquals("Phone not found.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Find All Phones Test")
//    public void findAllTest() {
//        when(phoneMapper.convertToDtoListWithoutId(phoneList)).thenReturn(phoneDtoWithoutIdList);
//        when(phoneRepository.findAll()).thenReturn(phoneList);
//
//        assertAll(() -> {
//            assertEquals(userPhoneService.findAll(), phoneDtoWithoutIdList);
//            assertNotEquals(userPhoneService.findAll(), phoneList);
//        });
//    }
//
//}
