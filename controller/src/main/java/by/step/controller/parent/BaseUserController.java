package by.step.controller.parent;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface BaseUserController<T> {

    @Operation(summary = "Найти все сущности", description = "Выводит всех сущности, которые есть в БД")
    @GetMapping("/findAll")
    List<T> findAll();

}
