package com.haterspoint.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@Table(name="comments")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;



    @Column(name = "comment")
    private String comment;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @Embedded
    private Generics generics;
}
