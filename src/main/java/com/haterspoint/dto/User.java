package com.haterspoint.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String emailId;
    private String password;
    private String mobileNumber;
    private String role;

}
