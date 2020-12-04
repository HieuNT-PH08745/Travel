package vn.nuce.service;

import vn.nuce.dto.ImageDto;

import java.util.List;

public interface ImageService {
    void saveImage(ImageDto vehicleDto);
    List<ImageDto> findAllImage();
    ImageDto findOneImage(Long id);
    ImageDto updateImages(ImageDto dto);
}
