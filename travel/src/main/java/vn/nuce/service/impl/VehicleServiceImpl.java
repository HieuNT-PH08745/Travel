package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.VehicleDto;
import vn.nuce.entity.VehicleEntity;
import vn.nuce.repository.impl.VehicleRepositoryImpl;
import vn.nuce.service.VehicleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public void saveVehicle(VehicleDto vehicleDto) {
        repository.save(getInstanceMapper().map(vehicleDto, VehicleEntity.class));
    }

    @Override
    public List<VehicleDto> findAllVehicle() {
        List<VehicleEntity> entities = repository.findAll();
        List<VehicleDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (VehicleEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, VehicleDto.class));
            }
        }
        return dtos;
    }

    @Override
    public VehicleDto findOneVehicle(Long id) {
        return getInstanceMapper().map(repository.findOne(id), VehicleDto.class);
    }

    @Override
    public VehicleDto updateVehicles(VehicleDto dto) {
        VehicleEntity entity = repository.update(getInstanceMapper().map(dto, VehicleEntity.class));
        return getInstanceMapper().map(entity, VehicleDto.class);
    }
}
