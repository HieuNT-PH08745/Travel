package vn.nuce.mapper;

import vn.nuce.dto.BookTourDto;
import vn.nuce.entity.BookTourEntity;

public class BookTourMapper {

    public static BookTourDto toBookTourDto(BookTourEntity bookTourEntity) {
        BookTourDto bookTourDto = new BookTourDto();

        bookTourDto.setRegistration_Id(bookTourEntity.getRegistration_Id());
        bookTourDto.setUserId(bookTourEntity.getUserId());
        bookTourDto.setTourId(bookTourEntity.getTourId());
        bookTourDto.setName(bookTourEntity.getName());
        bookTourDto.setPhone(bookTourEntity.getPhone());
        bookTourDto.setEmail(bookTourEntity.getEmail());
        bookTourDto.setPrice(bookTourEntity.getPrice());
        bookTourDto.setNote(bookTourEntity.getNote());
        bookTourDto.setNumChild(bookTourEntity.getNumChild());
        bookTourDto.setNumAdult(bookTourEntity.getNumAdult());
        bookTourDto.setStatus(bookTourEntity.getStatus());
        bookTourDto.setCreateDate(bookTourEntity.getCreateDate());

        return bookTourDto;
    }

    public static BookTourEntity toBookTourEntity(BookTourDto bookTourDto) {
        BookTourEntity bookTourEntity = new BookTourEntity();

        bookTourEntity.setRegistration_Id(bookTourDto.getRegistration_Id());
        bookTourEntity.setUserId(bookTourDto.getUserId());
        bookTourEntity.setTourId(bookTourDto.getTourId());
        bookTourEntity.setName(bookTourDto.getName());
        bookTourEntity.setPhone(bookTourDto.getPhone());
        bookTourEntity.setEmail(bookTourDto.getEmail());
        bookTourEntity.setPrice(bookTourDto.getPrice());
        bookTourEntity.setNote(bookTourDto.getNote());
        bookTourEntity.setNumChild(bookTourDto.getNumChild());
        bookTourEntity.setNumAdult(bookTourDto.getNumAdult());
        bookTourEntity.setStatus(bookTourDto.getStatus());
        bookTourEntity.setCreateDate(bookTourDto.getCreateDate());

        return bookTourEntity;
    }
}
