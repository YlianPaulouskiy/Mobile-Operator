package by.step.controller.parent;

import org.springframework.web.bind.annotation.*;

public interface BaseAdminController<T> extends BaseUserController<T> {

    @DeleteMapping("/removeById")
    void removeById(@RequestParam Long id);

}
