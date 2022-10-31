package by.step.controller.parent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BaseUserController<T> {

    @GetMapping("/findAll")
    List<T> findAll();

}
