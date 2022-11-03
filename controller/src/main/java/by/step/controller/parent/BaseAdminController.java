package by.step.controller.parent;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

public interface BaseAdminController<T> extends BaseUserController<T> {

    @Operation(summary = "Удалить сущность по Id", description = "Удаляет сущность с заданным Id из базы данных")
    @DeleteMapping("/removeById")
    void removeById(@RequestParam Long id);

}
