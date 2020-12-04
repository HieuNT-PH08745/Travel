package vn.nuce.data;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<ID extends Serializable, T> {
    void save(T entity);
    T update(T entity);
    Integer delete(List<ID> ids);
    List<T> findAll();
    T findOne(ID id);
}
