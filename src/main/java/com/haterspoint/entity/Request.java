package com.haterspoint.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@Table(name="request")
@AllArgsConstructor
@NoArgsConstructor
public class Request {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(9999)")
    private String description;

    @Column(name = "imageURL")
    private String imageURL;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;


    @Embedded
    private Generics generics;
}
