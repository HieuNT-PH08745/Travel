package vn.nuce.repository.impl;

import org.springframework.stereotype.Repository;
import vn.nuce.data.impl.CrudRepositoryImpl;
import vn.nuce.entity.TopicEntity;
import vn.nuce.repository.TopicRepository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class TopicRepositoryImpl extends CrudRepositoryImpl<Long, TopicEntity> implements TopicRepository {
}
