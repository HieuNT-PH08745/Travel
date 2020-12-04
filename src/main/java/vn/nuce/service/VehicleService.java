package vn.nuce.service;

import vn.nuce.dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDto vehicleDto);
    List<VehicleDto> findAllVehicle();
    VehicleDto findOneVehicle(Long id);
    VehicleDto updateVehicles(VehicleDto dto);
}
