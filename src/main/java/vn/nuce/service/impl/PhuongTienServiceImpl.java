package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.PhuongTienDto;
import vn.nuce.dto.TourDto;
import vn.nuce.entity.PhuongTienEntity;
import vn.nuce.entity.TourEntity;
import vn.nuce.entity.UserEntity;
//import vn.nuce.mapper.PhuongTienMapper;
import vn.nuce.repository.impl.PhuongTienRepositoryImpl;
import vn.nuce.repository.impl.TourRepositoryImpl;
import vn.nuce.service.PhuongTienService;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhuongTienServiceImpl implements PhuongTienService {

    @Autowired
    PhuongTienRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public void savePhuongTien(PhuongTienDto phuongTienDto) {
        repository.save(getInstanceMapper().map(phuongTienDto, PhuongTienEntity.class));
    }

    @Override
    public List<PhuongTienDto> findAllPhuongTien() {
        List<PhuongTienEntity> entities = repository.findAll();
        List<PhuongTienDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (PhuongTienEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, PhuongTienDto.class));
            }
        }
        return dtos;
    }

    @Override
    public PhuongTienDto findPhuongTien(Long id) {
        return getInstanceMapper().map(repository.findOne(id), PhuongTienDto.class);
    }

    @Override
    public PhuongTienDto updatePhuongTien(PhuongTienDto dto) {
        PhuongTienEntity entity = repository.update(getInstanceMapper().map(dto, PhuongTienEntity.class));
        return getInstanceMapper().map(entity, PhuongTienDto.class);
    }
}
