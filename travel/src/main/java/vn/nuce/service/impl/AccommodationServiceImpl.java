package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.AccommodationDto;
import vn.nuce.dto.ImageDto;
import vn.nuce.entity.AccommodationEntity;
import vn.nuce.entity.ImageEntity;
import vn.nuce.repository.impl.AccommodationRepositoryImpl;
import vn.nuce.service.AccommodationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    AccommodationRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public void saveAccommodation(AccommodationDto accommodationDto) {
        repository.save(getInstanceMapper().map(accommodationDto, AccommodationEntity.class));
    }

    @Override
    public List<AccommodationDto> findAllAccommodation() {
        List<AccommodationEntity> entities = repository.findAll();
        List<AccommodationDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (AccommodationEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, AccommodationDto.class));
            }
        }
        return dtos;
    }

    @Override
    public AccommodationDto findOneAccommodation(Long id) {
        return getInstanceMapper().map(repository.findOne(id), AccommodationDto.class);
    }

    @Override
    public AccommodationDto updateAccommodations(AccommodationDto dto) {
        AccommodationEntity entity = repository.update(getInstanceMapper().map(dto, AccommodationEntity.class));
        return getInstanceMapper().map(entity, AccommodationDto.class);
    }
}
