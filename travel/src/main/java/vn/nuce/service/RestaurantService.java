package vn.nuce.service;

import vn.nuce.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    void saveRestaurant(RestaurantDto restaurantDto);
    List<RestaurantDto> findAllRestaurant();
    RestaurantDto findOneRestaurant(Long id);
    RestaurantDto updateRestaurant(RestaurantDto dto);
}
