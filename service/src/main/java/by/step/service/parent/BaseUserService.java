package by.step.service.parent;

import java.util.List;

public interface BaseUserService<T> {

    T findOneById(Long id);

    List<T> findAll();

}
