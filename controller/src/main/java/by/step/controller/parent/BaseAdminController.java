package by.step.controller.parent;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface BaseAdminController<T> extends BaseUserController<T> {

    @PostMapping("/save")
    T save(@RequestBody T entity);

    @DeleteMapping("/removeById")
    void removeById(@RequestParam Long id);

}
