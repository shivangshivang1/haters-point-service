package com.haterspoint.mapper;

import com.haterspoint.dto.User;
import com.haterspoint.entity.UserEntity;
import com.haterspoint.util.Utility;

public class UserMapper {



    public static UserEntity convertUserDtoToUserEntity(User user) {

        return UserEntity.builder().emailId(user.getEmailId())
                .mobileNumber(user.getMobileNumber())
                .password(user.getPassword())
                .role("user")
                .generics(Utility.getCreateGenericDetails(user.getEmailId()))
                .build();

    }

    public static User convertUserEntityToUserDto(UserEntity userEntity){

        return User.builder().emailId(userEntity.getEmailId())
                .mobileNumber(userEntity.getMobileNumber())
                .role(userEntity.getRole())
                .build();
    }


}
