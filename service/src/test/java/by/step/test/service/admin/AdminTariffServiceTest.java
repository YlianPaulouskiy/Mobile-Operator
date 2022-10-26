package by.step.test.service.admin;

import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.tariffDto.TariffDto;
import by.step.dto.tariffDto.TariffPhoneDto;
import by.step.entity.Phone;
import by.step.entity.Tariff;
import by.step.mapper.TariffMapper;
import by.step.repository.TariffRepository;
import by.step.service.admin.impl.AdminTariffServiceImpl;
import by.step.service.exception.EntityNotCorrectException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminTariffServiceTest {

    @Mock
    private TariffRepository tariffRepository;

    @Mock
    private TariffMapper tariffMapper;

    @InjectMocks
    private AdminTariffServiceImpl adminTariffService;

    private static Tariff tariff = new Tariff();

    private static TariffPhoneDto tariffPhoneDto = new TariffPhoneDto();

    private static List<Tariff> tariffList = new ArrayList<>();

    private static List<TariffPhoneDto> tariffPhoneDtoList = new ArrayList<>();

    @BeforeAll
    public static void setup() {
        tariff.setId(1L);
        tariff.setName("Name");
        tariff.setMinutes(100);
        tariff.setMegabytes(100);
        tariff.setPrice(10.0);
        tariff.setPhoneList(new ArrayList<>());
        tariffList.add(tariff);

        tariffPhoneDto.setName("Name");
        tariffPhoneDto.setMinutes(100);
        tariffPhoneDto.setMegabytes(100);
        tariffPhoneDto.setPrice(10.0);
        tariffPhoneDto.setPhoneList(new ArrayList<>());
        tariffPhoneDtoList.add(tariffPhoneDto);

        TariffPhoneDto tariffDto1 = new TariffPhoneDto();
        tariffDto1.setName("tariffDto1");
        tariffDto1.setPrice(5.0);
        TariffPhoneDto tariffDto2 = new TariffPhoneDto();
        tariffDto2.setName("tariffDto2");
        tariffDto2.setPrice(7.0);
        TariffPhoneDto tariffDto3 = new TariffPhoneDto();
        tariffDto3.setName("tariffDto3");
        tariffDto3.setPrice(2.0);
        Collections.addAll(tariffPhoneDtoList, tariffDto1, tariffDto2, tariffDto3);

    }

    @Test
    @DisplayName("Find One Tariff By Id Test")
    public void findOneByIdTest() {
        when(tariffMapper.convertToDtoWithPhone(tariff)).thenReturn(tariffPhoneDto);
        when(tariffRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(tariff));

        assertAll(() -> {
            assertEquals(adminTariffService.findOneById(1L), tariffPhoneDto);
            assertNotEquals(adminTariffService.findOneById(1L), tariff);
        });
    }

    @Test
    @DisplayName("Find One Tariff By Null Id Test")
    public void findOneByIdNullTest() {
        Long id = 0L;
        Throwable exception = assertThrows(EntityNotFoundException.class,
                () -> adminTariffService.findOneById(id)
        );

        assertAll( () -> {
            assertEquals("Tariff id# 0 not found.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Find All Tariffs Test")
    public void findAllTest() {
        when(tariffMapper.convertToTariffPhoneDtoList(tariffList)).thenReturn(tariffPhoneDtoList);
        when(tariffRepository.findAll()).thenReturn(tariffList);

        assertAll(() -> {
            assertEquals(adminTariffService.findAll(), tariffPhoneDtoList);
            assertNotEquals(adminTariffService.findAll(), tariffList);
        });
    }

    @Test
    @DisplayName("Save Test")
    public void saveTest() {
        when(tariffMapper.convertToDtoWithPhone(ArgumentMatchers.any(Tariff.class))).thenReturn(tariffPhoneDto);
        when(tariffRepository.save(ArgumentMatchers.any(Tariff.class))).thenReturn(tariff);
        when(tariffMapper.convert(ArgumentMatchers.any(TariffPhoneDto.class))).thenReturn(tariff);

        assertAll(() -> {
            assertEquals(adminTariffService.save(tariffPhoneDto), tariffPhoneDto);
        });
    }

    @Test
    @DisplayName("Save Exists Exception Text")
    public void saveExistsExceptionTest() {
        when(tariffRepository.existsByPriceAndMinutesAndMegabytes(ArgumentMatchers.anyDouble(),
                ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(true);
        Throwable exception = assertThrows(EntityExistsException.class, () -> {
            adminTariffService.save(tariffPhoneDto);
        });

        assertAll(() -> {
            assertEquals("Tariff with this parameters already exists.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Save Incorrect Data Exception Test")
    public void saveIncorrectDataExceptionTest() {
        tariffPhoneDto.setPrice(-1.0);
        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
            adminTariffService.save(tariffPhoneDto);
        });

        assertAll(() -> {
            assertEquals("Check input sources.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Save Null Tariff Test")
    public void saveNullTariffTest() {
        Throwable exception = assertThrows(EntityNotCorrectException.class, () -> {
            adminTariffService.save(null);
        });

        assertAll(() -> {
            assertEquals("Input sources is null.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Remove Tariff Test")
    public void removeTest() {
        when(tariffRepository.existsById(1L)).thenReturn(true);
        adminTariffService.removeById(1L);
        verify(tariffRepository).deleteById(1L);
    }

    @Test
    @DisplayName("Remove Exception Tariff Test")
    public void removeExceptionTest() {
        when(tariffRepository.existsById(1L)).thenReturn(false);

        Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
            adminTariffService.removeById(1L);
        });

        assertAll(() -> {
            assertEquals("Tariff id# " + 1L + " not found.", exception.getMessage());
        });
    }

    @Test
    @DisplayName("Sort Tariffs By Price Test")
    public void sortTariffsByPriceTest() {
        when(tariffMapper.convertToTariffPhoneDtoList(tariffList)).thenReturn(tariffPhoneDtoList);
        when(tariffRepository.findAll()).thenReturn(tariffList);

        tariffPhoneDtoList.sort(Comparator.comparing(TariffDto::getPrice));

        assertAll(() -> {
            assertEquals(adminTariffService.sortTariffByPrice(), tariffPhoneDtoList);
        });
    }
}
