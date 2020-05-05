package com.haterspoint.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@Table(name = "brand")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {


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

    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    private String subCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand")
    private Set<Reaction> reactions;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand")
    private Set<Comment> comments;


    @Embedded
    private Generics generics;

}
