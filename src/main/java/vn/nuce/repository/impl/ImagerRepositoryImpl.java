package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.ImageEntity;
import vn.nuce.repository.ImageRepository;

@Repository
@Transactional
public class ImagerRepositoryImpl extends CrudRepositoryImpl<Long, ImageEntity> implements ImageRepository {
}
