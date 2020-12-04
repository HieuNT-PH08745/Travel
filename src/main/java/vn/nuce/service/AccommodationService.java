package vn.nuce.service;

import vn.nuce.dto.AccommodationDto;

import java.util.List;

public interface AccommodationService {

    void saveAccommodation(AccommodationDto accommodationDto);
    List<AccommodationDto> findAllAccommodation();
    AccommodationDto findOneAccommodation(Long id);
    AccommodationDto updateAccommodations(AccommodationDto dto);
}
