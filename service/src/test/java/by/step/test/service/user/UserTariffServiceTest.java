//package by.step.test.service.user;
//
//import by.step.dto.tariffDto.TariffDto;
//import by.step.dto.tariffDto.TariffDtoWithoutId;
//import by.step.entity.Tariff;
//import by.step.mapper.TariffMapper;
//import by.step.repository.TariffRepository;
//import by.step.service.user.impl.UserTariffServiceImpl;
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
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class UserTariffServiceTest {
//
//    @Mock
//    private TariffRepository tariffRepository;
//
//    @Mock
//    private TariffMapper tariffMapper;
//
//    @InjectMocks
//    private UserTariffServiceImpl userTariffService;
//
//    private static Tariff tariff = new Tariff();
//
//    private static TariffDtoWithoutId tariffDtoWithoutId = new TariffDtoWithoutId();
//
//    private static List<Tariff> tariffList = new ArrayList<>();
//
//    private static List<TariffDtoWithoutId> tariffDtoWithoutIdList = new ArrayList<>();
//
//    private static List<TariffDto> tariffDtoList = new ArrayList<>();
//
//    @BeforeAll
//    public static void setup() {
//        tariff.setId(1L);
//        tariff.setName("Name");
//        tariff.setMinutes(100);
//        tariff.setMegabytes(100);
//        tariff.setPrice(10.0);
//        tariff.setPhoneList(new ArrayList<>());
//        tariffList.add(tariff);
//
//        tariffDtoWithoutId.setName("Name");
//        tariffDtoWithoutId.setMinutes(100);
//        tariffDtoWithoutId.setMegabytes(100);
//        tariffDtoWithoutId.setPrice(10.0);
//        tariffDtoWithoutId.setPhoneList(new ArrayList<>());
//        tariffDtoWithoutIdList.add(tariffDtoWithoutId);
//
//        TariffDto tariffDto1 = new TariffDto();
//        tariffDto1.setName("tariffDto1");
//        tariffDto1.setPrice(5.0);
//        TariffDto tariffDto2 = new TariffDto();
//        tariffDto2.setName("tariffDto2");
//        tariffDto2.setPrice(7.0);
//        TariffDto tariffDto3 = new TariffDto();
//        tariffDto3.setName("tariffDto3");
//        tariffDto3.setPrice(2.0);
//        Collections.addAll(tariffDtoList, tariffDto1, tariffDto2, tariffDto3);
//
//    }
//
//    @Test
//    @DisplayName("Find One Tariff By Id Test")
//    public void findOneByIdTest() {
//        when(tariffMapper.convertToDtoWithoutId(tariff)).thenReturn(tariffDtoWithoutId);
//        when(tariffRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(tariff));
//
//        assertAll(() -> {
//            assertEquals(userTariffService.findOneById(1L), tariffDtoWithoutId);
//            assertNotEquals(userTariffService.findOneById(1L), tariff);
//        });
//    }
//
//    @Test
//    @DisplayName("Find One Tariff By Null Id Test")
//    public void findOneByIdNullTest() {
//        Long id = 0L;
//        Throwable exception = assertThrows(EntityNotFoundException.class,
//                () -> userTariffService.findOneById(id)
//        );
//
//        assertAll( () -> {
//            assertEquals("Tariff #0 not found.", exception.getMessage());
//        });
//    }
//
//    @Test
//    @DisplayName("Find All Tariffs Test")
//    public void findAllTest() {
//        when(tariffMapper.convertToDtoListWithoutId(tariffList)).thenReturn(tariffDtoWithoutIdList);
//        when(tariffRepository.findAll()).thenReturn(tariffList);
//
//        assertAll(() -> {
//            assertEquals(userTariffService.findAll(), tariffDtoWithoutIdList);
//            assertNotEquals(userTariffService.findAll(), tariffList);
//        });
//    }
//
//    @Test
//    @DisplayName("Sort Tariffs By Price Test")
//    public void sortTariffsByPriceTest() {
//        when(tariffMapper.convertToDtoListWithoutId(tariffList)).thenReturn(tariffDtoWithoutIdList);
//        when(tariffRepository.findAll()).thenReturn(tariffList);
//        when(tariffMapper.convertToDto(tariffDtoWithoutIdList)).thenReturn(tariffDtoList);
//
//        tariffDtoList.sort(Comparator.comparing(TariffDto::getPrice));
//
//        assertAll(() -> {
//            assertEquals(userTariffService.sortTariffByPrice(), tariffDtoList);
//        });
//    }
//
//}
