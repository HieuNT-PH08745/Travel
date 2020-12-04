package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.VehicleEntity;
import vn.nuce.repository.VehicleRepository;

@Repository
@Transactional
public class VehicleRepositoryImpl extends CrudRepositoryImpl<Long, VehicleEntity> implements VehicleRepository {
}
