package by.step.dto.clientDto;

import by.step.dto.phoneDto.PhoneClientDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientPhoneDto extends ClientDtoWithId {

    private List<PhoneClientDto> phoneList;

}
