package by.step.dto.phoneDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PhoneDto {

    private String countryCode;
    private String operatorCode;
    private String mobile;

}
