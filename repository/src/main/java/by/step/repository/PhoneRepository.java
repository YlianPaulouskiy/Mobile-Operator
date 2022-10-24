package by.step.repository;

import by.step.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

    Phone findByCountryCodeAndOperatorCodeAndMobile(String countryCode, String operatorCode, String mobile);

    Boolean existsByCountryCodeAndOperatorCodeAndMobile(String countryCode, String operatorCode, String mobile);
}
