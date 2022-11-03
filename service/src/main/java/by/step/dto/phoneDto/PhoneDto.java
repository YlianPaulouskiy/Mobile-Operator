package by.step.dto.phoneDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode
public class PhoneDto {

    @NotBlank
    @Pattern(regexp = "^\\+(\\d{2,})", message = "Incorrect countryCode format. Need match regex: \"^\\\\+(\\\\d{2,})\" ")
    private String countryCode;

    @NotBlank
    @Pattern(regexp = "\\d+", message = "Incorrect operatorCode format. Need match regex: \"\\\\d+\"")
    private String operatorCode;

    @NotBlank
    @Pattern(regexp = "\\d{5,}", message = "Incorrect mobile format. Need match regex: \"\\\\d{5,}\"")
    private String mobile;

}