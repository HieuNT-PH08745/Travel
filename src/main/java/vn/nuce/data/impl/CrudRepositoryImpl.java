package vn.nuce.data.impl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.CrudRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
public class CrudRepositoryImpl<ID extends Serializable, T> implements CrudRepository<ID, T> {

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> persistenceClass;

    public String getPersistenceClassName() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[1];
        return persistenceClass.getSimpleName();
    }

    @Override
    public void save(T entity) {
        try {
            sessionFactory.getCurrentSession().persist(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T update(T entity) {
        T en = null;
        try {
            en = (T) sessionFactory.getCurrentSession().merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return en;
    }

    @Override
    public Integer delete(List<ID> ids) {
        int count = 0;
        try {
            if (ids.size() > 0) {
                for (ID id : ids) {
                    T item = sessionFactory.getCurrentSession().get(persistenceClass, id);
                    sessionFactory.getCurrentSession().remove(item);
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<T> findAll() {
        List<T> entities = null;
        try {
            StringBuilder sql = new StringBuilder("FROM ");
            sql.append(getPersistenceClassName());
            entities = sessionFactory.getCurrentSession().createQuery(sql.toString()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public T findOne(ID id) {
        T entity = null;
        try {
            if (id != null) {
                entity = sessionFactory.getCurrentSession().get(persistenceClass,id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
