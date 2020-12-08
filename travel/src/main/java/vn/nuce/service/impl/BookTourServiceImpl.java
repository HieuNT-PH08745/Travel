package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.BookTourDto;
import vn.nuce.entity.BookTourEntity;
import vn.nuce.mapper.BookTourMapper;
import vn.nuce.repository.impl.BookTourRepositoryImpl;
import vn.nuce.service.BookTourService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookTourServiceImpl implements BookTourService {

    @Autowired
    BookTourRepositoryImpl bookTourRepository;

    private ModelMapper mapper = null;

    @Override
    public List<BookTourDto> findAll() {
        List<BookTourEntity> bookTourEntities = bookTourRepository.findAll();
        List<BookTourDto> bookTourDtos = new ArrayList<BookTourDto>();

        if (bookTourEntities.size() > 0) {
            for (BookTourEntity bookTourEntity : bookTourEntities) {
                bookTourDtos.add(BookTourMapper.toBookTourDto(bookTourEntity));
            }
        }
        return bookTourDtos;
    }

    @Override
    public BookTourDto findById(Long id) {
        return BookTourMapper.toBookTourDto(bookTourRepository.findOne(id));
    }

    @Override
    public void save(BookTourDto bookTourDto) {
        bookTourRepository.save(BookTourMapper.toBookTourEntity(bookTourDto));
    }

    @Override
    public void remove(List<Long> ids) {
        bookTourRepository.delete(ids);
    }
}
