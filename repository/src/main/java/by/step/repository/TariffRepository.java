package by.step.repository;

import by.step.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {

    Tariff findTariffByPriceBetweenAndMinutesBetweenAndMegabytesBetween(
            Double priceFrom, Double priceTo,
            Integer minutesFrom, Integer minutesTo,
            Integer megabytesFrom, Integer megabytesTo
    );

    Boolean existsByPriceAndMinutesAndMegabytes(Double price, Integer minutes, Integer megabytes);

    Tariff findTariffByName(String tariffName);

}
