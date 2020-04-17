package com.haterspoint.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@Table(name = "reaction")
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "reaction")
    private String reaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user",nullable = false)
    private UserEntity user;



    @Embedded
    private Generics generics;


}
