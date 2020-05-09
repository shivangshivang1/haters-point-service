package com.haterspoint.mapper;

import com.haterspoint.dto.ReactionDTO;
import com.haterspoint.entity.Brand;
import com.haterspoint.entity.Reaction;
import com.haterspoint.entity.UserEntity;
import com.haterspoint.repository.BrandRepository;
import com.haterspoint.repository.UserRepository;
import com.haterspoint.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ReactionMapper {

    public static Reaction convertReactionDTOtoReaction(ReactionDTO reactionDTO, UserEntity u, Brand b)
    {
        try
        {
            return Reaction.builder().user(u)
                    .reaction(reactionDTO.getReaction())
                    .brand(b)
                    .generics(Utility.getCreateGenericDetails(String.valueOf(reactionDTO.getUserId())))
                    .build();
        }
        catch (Exception ex)
        {
            log.info("Failed at ReactionMapper: "+ ex.getMessage());
            return Reaction.builder().build();
        }

    }
}
