package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.BookTourDto;
import vn.nuce.dto.TourDto;
import vn.nuce.entity.BookTourEntity;
import vn.nuce.mapper.BookTourMapper;
import vn.nuce.repository.impl.BookTourRepositoryImpl;
import vn.nuce.service.BookTourService;
import vn.nuce.service.TourService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookTourServiceImpl implements BookTourService {

    @Autowired
    BookTourRepositoryImpl bookTourRepository;

    @Autowired
    TourService tourService;

    private ModelMapper mapper = null;

    @Override
    public List<BookTourDto> findAll() {
        List<BookTourEntity> bookTourEntities = bookTourRepository.findAll();
        List<BookTourDto> bookTourDtos = new ArrayList<BookTourDto>();

        if (bookTourEntities.size() > 0) {
            for (BookTourEntity bookTourEntity : bookTourEntities) {
                BookTourDto bookTourDto = BookTourMapper.toBookTourDto(bookTourEntity);
                bookTourDtos.add(bookTourDto);
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

    @Override
    public TourDto findTour(Long bookId) {
        List<TourDto> tourDtos = tourService.findAllTours();
        BookTourEntity bookTourEntity = bookTourRepository.findOne(bookId);
        TourDto tourDto = new TourDto();
        for (TourDto tourDto1 : tourDtos) {
            if (bookTourEntity.getTourId() == tourDto1.getTour_Id()) {
                tourDto = tourDto1;
            }
        }
        return tourDto;
    }

}
