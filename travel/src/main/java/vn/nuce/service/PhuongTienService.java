package vn.nuce.service;

import vn.nuce.dto.PhuongTienDto;

import java.util.List;

public interface PhuongTienService {

    void savePhuongTien(PhuongTienDto phuongTienDto);
    List<PhuongTienDto> findAllPhuongTien();
    PhuongTienDto findPhuongTien(Long id);
    PhuongTienDto updatePhuongTien(PhuongTienDto dto);
}
