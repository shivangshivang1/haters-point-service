package com.haterspoint.repository;

import com.haterspoint.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RequestRepository extends JpaRepository<Request, Serializable> {
    com.haterspoint.entity.Request findByRequest(String request);

}