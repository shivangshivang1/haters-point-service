package com.haterspoint.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
