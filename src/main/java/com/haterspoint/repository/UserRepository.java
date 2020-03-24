package com.haterspoint.repository;

import com.haterspoint.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Serializable> {
}
