package by.step.dto.phoneDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PhoneDtoWithId extends PhoneDto {

    private Long id;

    private String dateCreation;

}
