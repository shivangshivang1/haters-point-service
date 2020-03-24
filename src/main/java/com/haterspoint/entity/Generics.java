package com.haterspoint.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Data
public class Generics {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private String createdTime;
    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_time")
    private String modifiedTime;
}
