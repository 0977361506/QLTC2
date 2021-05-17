package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "report")
@Getter
@Setter

public class Report {
    //    id INT IDENTITY(1,1) PRIMARY KEY,
    //    ten nVARCHAR(100),
    //    nguoitao nVARCHAR(100) ,
    //    ngaytao nVARCHAR(100),
    //	code int ,
    //	src nvarchar(255)

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    private  String ten ;
    private  String nguoitao ;
    private  String ngaytao ;
    private  Integer code ;
    private  String src ;
}
