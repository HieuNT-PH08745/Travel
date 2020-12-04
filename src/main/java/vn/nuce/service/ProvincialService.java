package vn.nuce.service;

import vn.nuce.dto.ProvincialDto;

import java.util.List;

public interface ProvincialService {

    void saveProvincial(ProvincialDto provincialDto);
    List<ProvincialDto> findAllProvincial();
    ProvincialDto findOneProvincial(Long id);
    ProvincialDto updateProvincial(ProvincialDto dto);
}
