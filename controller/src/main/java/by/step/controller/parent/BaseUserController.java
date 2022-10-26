package by.step.controller.parent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BaseUserController<T> {

    @GetMapping("/findById")
    T findOneById(@RequestParam Long id);

    @GetMapping("/findAll")
    List<T> findAll();


}
