package by.step.dto.clientDto;

import by.step.dto.phoneDto.PhoneDtoWithId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientPhoneDto extends ClientDtoWithId {

    private List<PhoneDtoWithId> phoneList;

}
