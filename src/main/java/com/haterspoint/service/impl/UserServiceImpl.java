package com.haterspoint.service.impl;

import com.haterspoint.dto.User;
import com.haterspoint.entity.UserEntity;
import com.haterspoint.mapper.UserMapper;
import com.haterspoint.repository.UserRepository;
import com.haterspoint.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer signUp(User user) {

        UserEntity userEntity = userRepository.findByEmailId(user.getEmailId());
        if (userEntity == null) {
            UserEntity newUserEntity = UserMapper.convertUserDtoToUserEntity(user);
            UserEntity isUserSaved = userRepository.save(newUserEntity);
            if (!ObjectUtils.isEmpty(isUserSaved)) {
                return 200;
            }
        }
        else{
            return 206;
        }
        return 0;
    }

}
