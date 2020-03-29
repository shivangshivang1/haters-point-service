package com.haterspoint.controller;


import com.haterspoint.dto.User;
import com.haterspoint.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/sign-up")
    public ResponseEntity<Integer> userSignup(@RequestBody  User user) {
        log.info("user controller {}");
        int responseCode = userService.signUp(user);
        if(responseCode == 200){
            return new ResponseEntity<Integer>(responseCode, HttpStatus.OK);

        }
        return  new ResponseEntity<Integer>(responseCode,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping(value = "/login")
    public ResponseEntity<Integer> userLogin(@RequestBody User user){

        log.info("user controller{}");
        int responseCode = userService.login(user);
       if(responseCode == 200) {
           return new ResponseEntity<Integer>(responseCode, HttpStatus.OK);
       }
       else if(responseCode==206) {
           return new ResponseEntity<Integer>(responseCode, HttpStatus.PARTIAL_CONTENT);
       }
       else{
           //email id not present in the database
           return new ResponseEntity<Integer>(responseCode,HttpStatus.NO_CONTENT);
       }







    }



}
