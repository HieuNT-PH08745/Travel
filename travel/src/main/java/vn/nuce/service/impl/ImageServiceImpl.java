package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.ImageDto;
import vn.nuce.entity.ImageEntity;
import vn.nuce.repository.impl.ImagerRepositoryImpl;
import vn.nuce.service.ImageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImagerRepositoryImpl repository;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public void saveImage(ImageDto imageDto) {
        repository.save(getInstanceMapper().map(imageDto, ImageEntity.class));
    }

    @Override
    public List<ImageDto> findAllImage() {
        List<ImageEntity> entities = repository.findAll();
        List<ImageDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (ImageEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, ImageDto.class));
            }
        }
        return dtos;
    }

    @Override
    public ImageDto findOneImage(Long id) {
        return getInstanceMapper().map(repository.findOne(id), ImageDto.class);
    }

    @Override
    public ImageDto updateImages(ImageDto dto) {
        ImageEntity entity = repository.update(getInstanceMapper().map(dto, ImageEntity.class));
        return getInstanceMapper().map(entity, ImageDto.class);
    }
}
