package by.step.dto.clientDto;

import by.step.dto.phoneDto.PhoneDtoWithoutId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ClientDtoWithoutId extends ClientDto {

    private List<PhoneDtoWithoutId> phoneList;

}
