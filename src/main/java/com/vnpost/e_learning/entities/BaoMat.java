package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BaoMat")
@Getter
@Setter
public class BaoMat {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private  String time ;
    private  String action ;
    private  String url ;
    private  Integer maND ;
    private  String note ;
}
