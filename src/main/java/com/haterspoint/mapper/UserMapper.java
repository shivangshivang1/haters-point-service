package com.haterspoint.mapper;

import com.haterspoint.dto.User;
import com.haterspoint.entity.UserEntity;

public class UserMapper {

    public static UserEntity convertUserDtoToUserEntity(User user) {

        return UserEntity.builder().emailId(user.getEmailId())
                .mobileNumber(user.getMobileNumber())
                .password(user.getPassword())
                .role("user")
                .build();

    }

    public static User convertUserEntityToUserDto(UserEntity userEntity){

        return User.builder().emailId(userEntity.getEmailId())
                .mobileNumber(userEntity.getMobileNumber())
                .role(userEntity.getRole())
                .build();
    }


}
