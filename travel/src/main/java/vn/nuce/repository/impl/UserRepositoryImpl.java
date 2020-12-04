package vn.nuce.repository.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.UserEntity;
import vn.nuce.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl extends CrudRepositoryImpl<Long, UserEntity> implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Object[] checkLogin(String user_Name, String user_Password) {
        boolean isSuccess = false;
        UserEntity entity = null;
        try {
            StringBuilder sql = new StringBuilder("FROM ");
            sql.append(getPersistenceClassName());
            if (StringUtils.isNotBlank(user_Name) && StringUtils.isNotBlank(user_Password)) {
                sql.append(" WHERE user_Name =:user_Name AND user_Password =:user_Password");
            }
            Query query = sessionFactory.getCurrentSession().createQuery(sql.toString());
            if (StringUtils.isNotBlank(user_Name) && StringUtils.isNotBlank(user_Password)) {
                query.setParameter("user_Name", user_Name);
                query.setParameter("user_Password", user_Password);
            }
            entity = (UserEntity) query.uniqueResult();
            if (entity != null)
                isSuccess = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Object[]{isSuccess, entity};
    }
}
