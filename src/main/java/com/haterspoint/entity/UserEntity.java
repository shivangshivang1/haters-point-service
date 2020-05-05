package com.haterspoint.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    @Column(name="reference_id")
    private String referenceId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name = "user")
    private Set<Comment> comments;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name = "user")
    private Set<Brand> brands;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name = "user")
    private Set<Reaction> reaction;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(unique = true, name = "user")
    private Set<Request> requests;

    @Embedded
    private Generics generics;

}
