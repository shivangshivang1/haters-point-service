package com.haterspoint.controller;

import com.haterspoint.dto.ReactionDTO;
import com.haterspoint.service.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class ReactionController {

    @Autowired
    ReactionService reactionService;

    @PostMapping(value = "/save-reaction")
    public ResponseEntity<Integer> saveUserReaction(@RequestBody ReactionDTO reactionDTO)
    {
        log.info("Reaction controller {}");
        try
        {
            int responseCode = reactionService.saveReaction(reactionDTO);
            if (responseCode == 200)
                return new ResponseEntity<Integer>(responseCode, HttpStatus.OK);
            return new ResponseEntity<Integer>(responseCode,HttpStatus.BAD_REQUEST);
        }
        catch (Exception ex){
            log.info("Failed at Reaction Controller: " + ex.getMessage());
            return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
        }

    }
}
