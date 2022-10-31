//package by.step.test.mapper;
//
//import by.step.dto.phoneDto.PhoneClientDto;
//import by.step.dto.phoneDto.PhoneDto;
//import by.step.dto.phoneDto.PhoneDtoWithId;
//import by.step.dto.phoneDto.PhoneDtoWithoutId;
//import by.step.entity.Client;
//import by.step.entity.Phone;
//import by.step.entity.Tariff;
//import by.step.mapper.PhoneMapper;
//import by.step.mapper.PhoneMapperImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class PhoneMapperTest {
//
//    private final PhoneMapper phoneMapper = new PhoneMapperImpl();
//
//    private Phone phone = new Phone();
//    private PhoneDto phoneDto;
//    private PhoneDtoWithId phoneDtoWithId;
//    private PhoneClientDto phoneClientDto;
//    private PhoneDtoWithoutId phoneDtoWithoutId;
//
//    @Before
//    public void setPhone() {
//        phone.setId(1L);
//        phone.setCountryCode("+375");
//        phone.setOperatorCode("33");
//        phone.setMobile("1234567");
//        phone.setDateCreation(new Date());
//        phone.setTariff(new Tariff());
//        phone.setClient(new Client());
//    }
//
//    @Test
//    @DisplayName("Convert Phone to PhoneDto Test")
//    public void convertToPhoneDtoTest() {
//        phoneDto = phoneMapper.convertToDto(phone);
//        assertThat(phone.getCountryCode()).isEqualTo(phoneDto.getCountryCode());
//        assertThat(phone.getOperatorCode()).isEqualTo(phoneDto.getOperatorCode());
//        assertThat(phone.getMobile()).isEqualTo(phoneDto.getMobile());
//    }
//
//    @Test
//    @DisplayName("Convert Phone to PhoneDtoWithId Test")
//    public void convertToPhoneDtoWithIdTest() {
//        phoneDtoWithId = phoneMapper.convertToDtoWithId(phone);
//        assertThat(phone.getCountryCode()).isEqualTo(phoneDtoWithId.getCountryCode());
//        assertThat(phone.getOperatorCode()).isEqualTo(phoneDtoWithId.getOperatorCode());
//        assertThat(phone.getMobile()).isEqualTo(phoneDtoWithId.getMobile());
//        assertThat(phone.getId()).isEqualTo(phoneDtoWithId.getId());
//        assertThat(new SimpleDateFormat().format(phone.getDateCreation())).isEqualTo(phoneDtoWithId.getDateCreation());
//    }
//
//    @Test
//    @DisplayName("Convert Phone to PhoneClientDto Test")
//    public void convertToPhoneClientDtoTest() {
//        phoneClientDto = phoneMapper.convertToDtoWithClient(phone);
//        assertThat(phone.getCountryCode()).isEqualTo(phoneClientDto.getCountryCode());
//        assertThat(phone.getOperatorCode()).isEqualTo(phoneClientDto.getOperatorCode());
//        assertThat(phone.getMobile()).isEqualTo(phoneClientDto.getMobile());
//        assertThat(phone.getId()).isEqualTo(phoneClientDto.getId());
//        assertThat(new SimpleDateFormat().format(phone.getDateCreation())).isEqualTo(phoneClientDto.getDateCreation());
//        assertThat(phoneClientDto.getClient()).isNotNull();
//        assertThat(phoneClientDto.getTariff()).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Convert from PhoneDto to Phone Test")
//    public void convertFromPhoneDtoTest() {
//        phoneDto = phoneMapper.convertToDto(phone);
//        phone = phoneMapper.convert(phoneDto);
//        assertThat(phoneDto.getCountryCode()).isEqualTo(phone.getCountryCode());
//        assertThat(phoneDto.getOperatorCode()).isEqualTo(phone.getOperatorCode());
//        assertThat(phoneDto.getMobile()).isEqualTo(phone.getMobile());
//    }
//
//    @Test
//    @DisplayName("Convert from PhoneDtoWithId to Phone Test")
//    public void convertFromPhoneDtoWithIdTest() {
//        phoneDtoWithId = phoneMapper.convertToDtoWithId(phone);
//        phone = phoneMapper.convert(phoneDtoWithId);
//        assertThat(phoneDtoWithId.getCountryCode()).isEqualTo(phone.getCountryCode());
//        assertThat(phoneDtoWithId.getOperatorCode()).isEqualTo(phone.getOperatorCode());
//        assertThat(phoneDtoWithId.getMobile()).isEqualTo(phone.getMobile());
//        assertThat(phoneDtoWithId.getId()).isEqualTo(phone.getId());
//        assertThat(phoneDtoWithId.getDateCreation()).isEqualTo(new SimpleDateFormat().format(phone.getDateCreation()));
//    }
//
//    @Test
//    @DisplayName("Convert from PhoneClientDto to Phone Test")
//    public void convertFromPhoneClientDtoTest() {
//        phoneClientDto = phoneMapper.convertToDtoWithClient(phone);
//        phone = phoneMapper.convert(phoneClientDto);
//        assertThat(phoneClientDto.getCountryCode()).isEqualTo(phone.getCountryCode());
//        assertThat(phoneClientDto.getOperatorCode()).isEqualTo(phone.getOperatorCode());
//        assertThat(phoneClientDto.getMobile()).isEqualTo(phone.getMobile());
//        assertThat(phoneClientDto.getId()).isEqualTo(phone.getId());
//        assertThat(phoneClientDto.getDateCreation()).isEqualTo(new SimpleDateFormat().format(phone.getDateCreation()));
//        assertThat(phone.getClient()).isNotNull();
//        assertThat(phone.getTariff()).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Convert Phone to PhoneDtoWithoutId Test")
//    public void convertToClientDtoWithoutIdTest() {
//        phoneDtoWithoutId = phoneMapper.convertToDtoWithoutId(phone);
//        assertThat(phone.getCountryCode()).isEqualTo(phoneDtoWithoutId.getCountryCode());
//        assertThat(phone.getOperatorCode()).isEqualTo(phoneDtoWithoutId.getOperatorCode());
//        assertThat(phone.getMobile()).isEqualTo(phoneDtoWithoutId.getMobile());
//        assertThat(phoneDtoWithoutId.getTariff()).isNotNull();
//        assertThat(phoneDtoWithoutId.getClient()).isNotNull();
//    }
//
//    @Test
//    @DisplayName("Convert to Client from ClientDtoWithoutId Test")
//    public void convertToClientFromDtoWithoutIdTest() {
//        phoneDtoWithoutId =phoneMapper.convertToDtoWithoutId(phone);
//        phone = phoneMapper.convert(phoneDtoWithoutId);
//        assertThat(phoneDtoWithoutId.getCountryCode()).isEqualTo(phone.getCountryCode());
//        assertThat(phoneDtoWithoutId.getOperatorCode()).isEqualTo(phone.getOperatorCode());
//        assertThat(phoneDtoWithoutId.getMobile()).isEqualTo(phone.getMobile());
//        assertThat(phone.getClient()).isNotNull();
//        assertThat(phone.getTariff()).isNotNull();
//    }
//}
