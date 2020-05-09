package com.haterspoint.service.impl;

import com.haterspoint.dto.ReactionDTO;
import com.haterspoint.entity.Brand;
import com.haterspoint.entity.Reaction;
import com.haterspoint.entity.UserEntity;
import com.haterspoint.mapper.ReactionMapper;
import com.haterspoint.repository.BrandRepository;
import com.haterspoint.repository.ReactionRepository;
import com.haterspoint.repository.UserRepository;
import com.haterspoint.service.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    ReactionRepository reactionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Integer saveReaction(ReactionDTO reactionDTO)
    {
        try
        {
            UserEntity userEntity = userRepository.findById(reactionDTO.getUserId());
            Brand brand = brandRepository.findById(reactionDTO.getProductId());
            if(userEntity != null && brand!=null)
            {
                Reaction newReaction = ReactionMapper.convertReactionDTOtoReaction(reactionDTO,userEntity,brand);
                Reaction isReactionSaved = reactionRepository.save(newReaction);
                if(!ObjectUtils.isEmpty(isReactionSaved))
                    return 200;
            }
            return 0;
        }
        catch (Exception ex)
        {
            log.info("Failed at ReactionServiceImpl: "+ ex.getMessage());
            return 0;
        }


    }
}
