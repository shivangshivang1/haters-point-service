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

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Integer signUp(User user) {

//        UserEntity userEntity = UserMapper.convertUserDtoToUserEntity(user);
//        UserEntity isUserSaved = userRepository.save(userEntity);
//        if(!ObjectUtils.isEmpty(isUserSaved)){
//            return 200;
//        }

        List<UserEntity> userEntities = userRepository.findByEmailId(user.getEmailId());
        if(userEntities.size()== 0){
            UserEntity userEntity = UserMapper.convertUserDtoToUserEntity(user);
            UserEntity isUserSaved = userRepository.save(userEntity);
            if(!ObjectUtils.isEmpty(isUserSaved)){
                return 200;
            }
        }
        return 0;
    }

    @Override
    public Integer logIn(User user) {
        //List<UserEntity> userEntitie = userRepository.findByEmailId(user.getEmailId());
        List<UserEntity> userEntities = userRepository.findAll();

        for(UserEntity a : userEntities){
            if(a.getEmailId().equals(user.getEmailId())){
                if(a.getPassword().compareTo(user.getPassword())== 0){
                            return 200;
                }else{
                    return 206;
                }
            }
        }
        return 204;
    }


}
