package com.haterspoint.service.impl;

import com.haterspoint.dto.User;
import com.haterspoint.entity.UserEntity;
import com.haterspoint.mapper.UserMapper;
import com.haterspoint.repository.UserRepository;
import com.haterspoint.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer signUp(User user) {

        UserEntity userEntity = UserMapper.convertUserDtoToUserEntity(user);
        UserEntity isUserSaved = userRepository.save(userEntity);
        if(!ObjectUtils.isEmpty(isUserSaved)){
            return 200;
        }

        return 0;
    }

}
