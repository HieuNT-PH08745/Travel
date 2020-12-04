package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.RestaurantEntity;
import vn.nuce.repository.RestaurantRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RestaurantRepositoryImpl extends CrudRepositoryImpl<Long, RestaurantEntity> implements RestaurantRepository {
}
