package by.step.dto.phoneDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PhoneDtoWithId extends PhoneDto {

    private Long id;
    private String dateCreation;

}
