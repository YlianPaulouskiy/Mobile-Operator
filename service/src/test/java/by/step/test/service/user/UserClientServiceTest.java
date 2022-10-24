package by.step.test.service.user;

import by.step.dto.clientDto.ClientPhoneDto;
import by.step.dto.phoneDto.PhoneClientDto;
import by.step.dto.phoneDto.PhoneDto;
import by.step.entity.Client;
import by.step.entity.Phone;
import by.step.mapper.ClientMapper;
import by.step.mapper.PhoneMapperImpl;
import by.step.repository.ClientRepository;
import by.step.service.user.UserClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private UserClientService userClientService;

    private ClientPhoneDto clientPhoneDto = new ClientPhoneDto();

    @Before
    public void setup() {
        ClientPhoneDto clientPhoneDto = new ClientPhoneDto();
        clientPhoneDto.setName("Name");
        clientPhoneDto.setLastName("LastName");
        clientPhoneDto.setPatronymic("Patronymic");

        List<PhoneClientDto> phoneClientDtoList = new ArrayList<>();
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setCountryCode("+375");
        phoneDto.setOperatorCode("44");
        phoneDto.setMobile("1234567");

        phoneClientDtoList.add(
                new PhoneMapperImpl().convertToDtoWithClient(
                        new PhoneMapperImpl().convert(phoneDto)
                )
        );
        clientPhoneDto.setPhoneList(phoneClientDtoList);
        this.clientPhoneDto = clientMapper.convertToDtoWithPhone(
                clientRepository.save(
                        clientMapper.convert(clientPhoneDto)));

    }

    @Test
    @DisplayName("")
    public void findOneByIdTest() {
        assertThat(userClientService.findOneById(1L))
                .isNotNull()
                .isEqualTo(clientPhoneDto);
    }
}
