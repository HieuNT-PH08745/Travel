package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.AccommodationEntity;
import vn.nuce.repository.AccommodationRepository;

@Repository
@Transactional
public class AccommodationRepositoryImpl extends CrudRepositoryImpl<Long, AccommodationEntity> implements AccommodationRepository {
}
