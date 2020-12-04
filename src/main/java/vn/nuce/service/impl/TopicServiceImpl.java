package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.RestaurantDto;
import vn.nuce.dto.TopicDto;
import vn.nuce.entity.RestaurantEntity;
import vn.nuce.entity.TopicEntity;
import vn.nuce.repository.impl.TopicRepositoryImpl;
import vn.nuce.service.TopicService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public void saveTopic(TopicDto topicDto) {
        repository.save(getInstanceMapper().map(topicDto, TopicEntity.class));
    }

    @Override
    public List<TopicDto> findAllTopic() {
        List<TopicEntity> entities = repository.findAll();
        List<TopicDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (TopicEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, TopicDto.class));
            }
        }
        return dtos;
    }

    @Override
    public TopicDto findOneTopic(Long id) {
        return getInstanceMapper().map(repository.findOne(id), TopicDto.class);
    }

    @Override
    public TopicDto updateTopic(TopicDto dto) {
        TopicEntity entity = repository.update(getInstanceMapper().map(dto, TopicEntity.class));
        return getInstanceMapper().map(entity, TopicDto.class);
    }
}
