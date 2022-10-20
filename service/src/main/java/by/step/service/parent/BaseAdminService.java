package by.step.service.parent;

public interface BaseAdminService<T> extends BaseUserService<T> {

    T save(T entity);

    void removeById(Long id);

}