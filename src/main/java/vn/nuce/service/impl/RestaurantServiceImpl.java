package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.RestaurantDto;
import vn.nuce.entity.RestaurantEntity;
import vn.nuce.repository.impl.RestaurantRepositoryImpl;
import vn.nuce.service.RestaurantService;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public void saveRestaurant(RestaurantDto restaurantDto) {
        repository.save(getInstanceMapper().map(restaurantDto, RestaurantEntity.class));
    }

    @Override
    public List<RestaurantDto> findAllRestaurant() {
        List<RestaurantEntity> entities = repository.findAll();
        List<RestaurantDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (RestaurantEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, RestaurantDto.class));
            }
        }
        return dtos;
    }

    @Override
    public RestaurantDto findOneRestaurant(Long id) {
        return getInstanceMapper().map(repository.findOne(id), RestaurantDto.class);
    }

    @Override
    public RestaurantDto updateRestaurant(RestaurantDto dto) {
        RestaurantEntity entity = repository.update(getInstanceMapper().map(dto, RestaurantEntity.class));
        return getInstanceMapper().map(entity, RestaurantDto.class);
    }
}
