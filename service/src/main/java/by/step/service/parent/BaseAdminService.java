package by.step.service.parent;

public interface BaseAdminService<T> extends BaseUserService<T> {

    void removeById(Long id);

}
