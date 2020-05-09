package com.haterspoint.repository;

import com.haterspoint.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BrandRepository extends JpaRepository<Brand, Serializable> {
    Brand findById(int id);
}
