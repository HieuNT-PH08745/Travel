package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.BookTourEntity;
import vn.nuce.repository.BookTourRepository;

@Repository
@Transactional
public class BookTourRepositoryImpl extends CrudRepositoryImpl<Long, BookTourEntity> implements BookTourRepository {
}
