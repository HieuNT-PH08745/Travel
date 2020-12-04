package vn.nuce.service;

import vn.nuce.dto.TourDto;

import java.util.List;

public interface TourService {

    void saveTour(TourDto tourDto);
    List<TourDto> findAllTours();
    TourDto findOneTour(Long id);
    TourDto updateTour(TourDto dto);
}
