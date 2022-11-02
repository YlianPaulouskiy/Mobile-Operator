package by.step.repository;

import by.step.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone findByCountryCodeAndOperatorCodeAndMobile(String countryCode, String operatorCode, String mobile);

    Boolean existsByCountryCodeAndOperatorCodeAndMobile(String countryCode, String operatorCode, String mobile);

    List<Phone> findPhonesByTariffName(String tariffName);

    @Query(value = "select ph from Phone as ph where ph.client.name = ?1 and ph.client.lastName = ?2 " +
            "and ph.client.patronymic = ?3")
    List<Phone> findPhonesByClient(String name ,String lastName, String patronymic);
}
