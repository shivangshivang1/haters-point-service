package com.haterspoint.service.impl;

import com.haterspoint.dto.RequestDTO;
import com.haterspoint.entity.Request;
import com.haterspoint.mapper.RequestMapper;
import com.haterspoint.repository.RequestRepository;
import com.haterspoint.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Override
    public Integer postRequest(RequestDTO requestDTO) {
        Request request = requestRepository.findByRequest(requestDTO.getRequest());
        if (request == null) {
            Request newRequestEntity = RequestMapper.convertRequestDTOToRequest(requestDTO);
            Request isRequestSaved = requestRepository.save(newRequestEntity);
            if (!ObjectUtils.isEmpty(isRequestSaved)) {
                return 200;
            }
        } else {
            return 206;
        }
        return 0;
    }

    }
