package com.vnpost.e_learning.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter

public class PhieuChiTietBean implements Serializable {

    //select chitiet.gia , chitiet.giamgia , chitiet.soluong ,
    //hh.mahh , hh.tenhh

    private  Double gia  ;
    private  Double giamgia ;
    private  Integer soluong  ;
    private  Integer mahh ;
    private  String tenhh ;

    public PhieuChiTietBean(Double gia, Double giamgia, Integer soluong, Integer mahh, String tenhh) {
        this.gia = gia;
        this.giamgia = giamgia;
        this.soluong = soluong;
        this.mahh = mahh;
        this.tenhh = tenhh;
    }

    public PhieuChiTietBean() {

    }
}
