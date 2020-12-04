package vn.nuce.mapper;

import vn.nuce.dto.UserDto;
import vn.nuce.entity.UserEntity;

public class UserMapper {

    public static UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();

        userDto.setUser_Id(userEntity.getUser_Id());
        userDto.setUser_Fullname(userEntity.getUser_Fullname());
        userDto.setUser_Name(userEntity.getUser_Name());
        userDto.setUser_Password(userEntity.getUser_Password());
        userDto.setUser_Email(userEntity.getUser_Email());
        userDto.setUser_Phone(userEntity.getUser_Phone());
        userDto.setUser_Gender(userEntity.getUser_Gender());
        userDto.setUser_Lastupdate(userEntity.getUser_Lastupdate());
        userDto.setImage(userEntity.getImage());
        userDto.setUser_Createdate(userEntity.getUser_Createdate());
        userDto.setUser_Role(userEntity.getUser_Role());

        return userDto;
    }

    public static UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUser_Id(userDto.getUser_Id());
        userEntity.setUser_Fullname(userDto.getUser_Fullname());
        userEntity.setUser_Name(userDto.getUser_Name());
        userEntity.setUser_Password(userDto.getUser_Password());
        userEntity.setUser_Email(userDto.getUser_Email());
        userEntity.setUser_Phone(userDto.getUser_Phone());
        userEntity.setUser_Gender(userDto.getUser_Gender());
        userEntity.setUser_Lastupdate(userDto.getUser_Lastupdate());
        userEntity.setImage(userDto.getImage());
        userEntity.setUser_Createdate(userDto.getUser_Createdate());
        userEntity.setUser_Role(userDto.getUser_Role());

        return userEntity;
    }

}
