package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.ProvincialEntity;
import vn.nuce.repository.ProvincialRepository;

@Repository
@Transactional
public class ProvincialRepositoryImpl extends CrudRepositoryImpl<Long, ProvincialEntity> implements ProvincialRepository {
}
