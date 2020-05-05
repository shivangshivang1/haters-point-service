package com.haterspoint.repository;

import com.haterspoint.entity.Reaction;
import com.haterspoint.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Serializable> {

    List<Reaction> findByReactionAndBrand(String reaction, Integer brandID);
}
