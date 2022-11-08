package by.step.controller.parent;

import by.step.dto.clientDto.ClientPhoneDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated

public interface BaseAdminController<T> extends BaseUserController<T> {

    @Operation(summary = "Найти сущность по Id", description = "Выводит сущность, соответствующего заданному Id")
    @GetMapping("/findById")
    T findOneById(@NotNull @Positive @RequestParam Long id);

    @Operation(summary = "Удалить сущность по Id", description = "Удаляет сущность с заданным Id из базы данных")
    @DeleteMapping("/removeById")
    void removeById(@NotNull @Positive @RequestParam Long id);

}
