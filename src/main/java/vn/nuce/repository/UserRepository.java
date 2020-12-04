package vn.nuce.repository;

import vn.nuce.data.CrudRepository;
import vn.nuce.entity.UserEntity;

public interface UserRepository extends CrudRepository<Long, UserEntity> {
    Object[] checkLogin(String username,String password);
}
