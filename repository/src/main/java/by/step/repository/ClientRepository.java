package by.step.repository;

import by.step.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Boolean existsByNameAndLastNameAndPatronymic(String name, String lastName, String patronymic);

    Client findByNameAndLastNameAndPatronymic(String name, String lastName, String patronymic);

}
