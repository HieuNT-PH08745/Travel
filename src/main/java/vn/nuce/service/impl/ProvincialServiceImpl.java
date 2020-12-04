package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.ProvincialDto;
import vn.nuce.dto.TourDto;
import vn.nuce.entity.ProvincialEntity;
import vn.nuce.entity.RestaurantEntity;
import vn.nuce.entity.TourEntity;
import vn.nuce.repository.impl.ProvincialRepositoryImpl;
import vn.nuce.service.ProvincialService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvincialServiceImpl implements ProvincialService {

    @Autowired
    ProvincialRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }


    @Override
    public void saveProvincial(ProvincialDto provincialDto) {
        repository.save(getInstanceMapper().map(provincialDto, ProvincialEntity.class));
    }

    @Override
    public List<ProvincialDto> findAllProvincial() {
        List<ProvincialEntity> entities = repository.findAll();
        List<ProvincialDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (ProvincialEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, ProvincialDto.class));
            }
        }
        return dtos;
    }

    @Override
    public ProvincialDto findOneProvincial(Long id) {
        return getInstanceMapper().map(repository.findOne(id), ProvincialDto.class);
    }

    @Override
    public ProvincialDto updateProvincial(ProvincialDto dto) {
        ProvincialEntity entity = repository.update(getInstanceMapper().map(dto, ProvincialEntity.class));
        return getInstanceMapper().map(entity, ProvincialDto.class);
    }
}
