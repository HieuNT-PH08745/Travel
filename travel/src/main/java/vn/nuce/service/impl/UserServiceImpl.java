package vn.nuce.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.nuce.dto.BookTourDto;
import vn.nuce.dto.TourDto;
import vn.nuce.dto.UserDto;
import vn.nuce.entity.TourEntity;
import vn.nuce.entity.UserEntity;
import vn.nuce.mapper.UserMapper;
import vn.nuce.repository.TourRepository;
import vn.nuce.repository.impl.UserRepositoryImpl;
import vn.nuce.service.BookTourService;
import vn.nuce.service.TourService;
import vn.nuce.service.UserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepositoryImpl repository;

    @Autowired
    BookTourService bookTourService;

    @Autowired
    TourService tourService;

    private ModelMapper mapper = null;

    private ModelMapper getInstanceMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    @Override
    public Object[] checkLogin(String user_Name, String user_Password) {
        UserDto dto = null;
        Object[] objects = repository.checkLogin(user_Name, user_Password);
        boolean isSuccess = (boolean) objects[0];
        if (isSuccess) {
            dto = getInstanceMapper().map(objects[1], UserDto.class);
        }
        return new Object[]{isSuccess, dto};
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserEntity> entities = repository.findAll();
        List<UserDto> dtos = new ArrayList<>();
        if (entities.size() > 0) {
            for (UserEntity entity : entities) {
                dtos.add(getInstanceMapper().map(entity, UserDto.class));
            }
        }
        return dtos;
    }

    @Override
    public void saveUser(UserDto userDto) {
        repository.save(UserMapper.toUserEntity(userDto));
    }

    @Override
    public Integer deleteUser(List<Long> ids) {
        return repository.delete(ids);
    }

    @Override
    public UserDto findOneUser(Long id) {
        return UserMapper.toUserDto(repository.findOne(id));
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        UserEntity entity = repository.update(UserMapper.toUserEntity(dto));
        return UserMapper.toUserDto(entity);
    }

    @Override
    public List<BookTourDto> findBookTourByUserId(Long id) {
        List<BookTourDto> bookTourDtos = bookTourService.findAll();
        List<BookTourDto> bookTourDtos1 = new ArrayList<>();
        for (BookTourDto bookTourDto : bookTourDtos) {
            if (bookTourDto.getUserId() == id && bookTourDto.getStatus() == 1) {
                bookTourDtos1.add(bookTourDto);
            }
        }

        return bookTourDtos1;
    }

    @Override
    public List<BookTourDto> findBookTourWaitByUserId(Long id) {
        List<BookTourDto> bookTourDtos = bookTourService.findAll();
        List<BookTourDto> bookTourDtos1 = new ArrayList<>();
        for (BookTourDto bookTourDto : bookTourDtos) {
            if (bookTourDto.getUserId() == id && bookTourDto.getStatus() == 0) {
                bookTourDtos1.add(bookTourDto);
            }
        }

        return bookTourDtos1;
    }
}
