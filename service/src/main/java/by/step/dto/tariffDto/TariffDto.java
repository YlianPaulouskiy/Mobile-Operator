package by.step.dto.tariffDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class TariffDto {

    private String name;
    private Integer minutes;
    private Integer megabytes;
    private Double price;

}
