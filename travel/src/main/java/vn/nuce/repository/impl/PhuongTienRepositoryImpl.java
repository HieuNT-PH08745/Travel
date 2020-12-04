package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.PhuongTienEntity;
import vn.nuce.repository.PhuongTienRepository;

@Repository
@Transactional
public class PhuongTienRepositoryImpl extends CrudRepositoryImpl<Long, PhuongTienEntity> implements PhuongTienRepository  {
}
