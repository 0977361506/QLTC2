package com.vnpost.e_learning.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class DanhSachNhapHang {
    //    //select ct.hang_hoaid as maHH , ct.soluong as soluongnhap , ct.thang as thangnhap

    private  Integer maHH ;
    private  Integer soluongnhap ;
    private String thangnhap ;

    public DanhSachNhapHang(Integer maHH, Integer soluongnhap) {
        this.maHH = maHH;
        this.soluongnhap = soluongnhap;

    }

    public DanhSachNhapHang() {

    }
}
