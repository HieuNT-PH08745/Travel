package vn.nuce.service;

import vn.nuce.dto.BookTourDto;

import java.util.List;

public interface BookTourService {

    List<BookTourDto> findAll();

    BookTourDto findById(Long id);

    void save(BookTourDto bookTourDto);

    void remove(BookTourDto bookTourDto);
}
