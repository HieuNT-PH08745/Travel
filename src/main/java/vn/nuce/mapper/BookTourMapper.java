package vn.nuce.mapper;

import vn.nuce.dto.BookTourDto;
import vn.nuce.entity.BookTourEntity;

public class BookTourMapper {

    public static BookTourDto toBookTourDto(BookTourEntity bookTourEntity) {
        BookTourDto bookTourDto = new BookTourDto();

        bookTourDto.setId(bookTourEntity.getId());
        bookTourDto.setTourId(bookTourEntity.getTourId());
        bookTourDto.setNote(bookTourEntity.getNote());
        bookTourDto.setPhone(bookTourEntity.getPhone());
        bookTourDto.setAddress(bookTourEntity.getAddress());
        bookTourDto.setEmail(bookTourEntity.getEmail());
        bookTourDto.setName(bookTourEntity.getName());
        bookTourDto.setUserId(bookTourEntity.getUserId());

        return bookTourDto;
    }

    public static BookTourEntity toBookTourEntity(BookTourDto bookTourDto) {
        BookTourEntity bookTourEntity = new BookTourEntity();

        bookTourEntity.setId(bookTourDto.getId());
        bookTourEntity.setName(bookTourDto.getName());
        bookTourEntity.setEmail(bookTourDto.getEmail());
        bookTourEntity.setAddress(bookTourDto.getAddress());
        bookTourEntity.setPhone(bookTourDto.getPhone());
        bookTourEntity.setNote(bookTourDto.getNote());
        bookTourEntity.setTourId(bookTourDto.getTourId());
        bookTourEntity.setUserId(bookTourDto.getUserId());

        return bookTourEntity;
    }
}
