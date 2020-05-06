package com.haterspoint.mapper;

import com.haterspoint.dto.RequestDTO;
import com.haterspoint.entity.Request;

public class RequestMapper {
    public static RequestDTO convertRequestDTOToRequest(RequestDTO requestDTO){
        return Request.builder().user(requestDTO.getUserId())
                .name(requestDTO.getName())
                .imageURL(requestDTO.getImageUrl())
                .description(requestDTO.getDescription())

                .build();


    }
}
}
