package com.haterspoint.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "role")
    private String role;

    @Embedded
    private Generics generics;

}
