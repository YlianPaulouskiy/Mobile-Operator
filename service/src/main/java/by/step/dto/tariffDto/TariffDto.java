package by.step.dto.tariffDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@EqualsAndHashCode
public class TariffDto {

    @NotBlank(message = "name can not be null or empty")
    private String name;

    @Positive
    @NotNull
    private Integer minutes;

    @Positive
    @NotNull
    private Integer megabytes;

    @Positive
    @NotNull
    private Double price;

}
