package by.step.dto.tariffDto;

import lombok.Data;

@Data
public class TariffDto {

    private String name;

    private Integer minutes;

    private Integer megabytes;

    private Double price;
}
