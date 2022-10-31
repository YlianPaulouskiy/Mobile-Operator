package by.step.controller.parent;

import org.springframework.web.bind.annotation.*;

public interface BaseAdminController<T> extends BaseUserController<T> {

    @GetMapping("/findById")
    T findOneById(@RequestParam Long id);

    @PostMapping("/save")
    T save(@RequestBody T entity);

    @DeleteMapping("/removeById")
    void removeById(@RequestParam Long id);

}
