package com.haterspoint.repository;

import com.haterspoint.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Serializable> {

   UserEntity findByEmailId(String emailId);
   UserEntity findById(int id);
}
