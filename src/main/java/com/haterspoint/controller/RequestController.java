package com.haterspoint.controller;

import com.haterspoint.dto.RequestDTO;
import com.haterspoint.service.RequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class RequestController {
    @Autowired
    RequestService requestService;

    @PostMapping(value = "/request")
    public ResponseEntity<Integer> userRequest(@RequestBody RequestDTO requestDTO) {
        log.info("request controller {}");
        int responseCode;
        responseCode = requestService.postRequest(RequestDTO);
        if(responseCode == 200){
            return new ResponseEntity<Integer>(responseCode, HttpStatus.OK);
        }
        else if ( responseCode == 206){
            return new ResponseEntity<Integer>(responseCode,HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<Integer>(responseCode,HttpStatus.OK);

    }
}

}