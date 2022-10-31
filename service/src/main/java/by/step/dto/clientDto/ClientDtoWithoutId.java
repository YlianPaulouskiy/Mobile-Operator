package by.step.dto.clientDto;

import by.step.dto.phoneDto.PhoneDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDtoWithoutId extends ClientDto {

    private List<PhoneDto> phoneList;

}
