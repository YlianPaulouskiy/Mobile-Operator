package by.step.service.parent;

public interface BaseAdminService<T> extends BaseUserService<T> {

    T findOneById(Long id);

    void removeById(Long id);

}
