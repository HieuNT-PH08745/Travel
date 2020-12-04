package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.TourEntity;
import vn.nuce.repository.TourRepository;

@Repository
@Transactional
public class TourRepositoryImpl extends CrudRepositoryImpl<Long, TourEntity> implements TourRepository {
}
