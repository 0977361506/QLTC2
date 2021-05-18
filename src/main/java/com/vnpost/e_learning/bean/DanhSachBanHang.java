package com.vnpost.e_learning.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DanhSachBanHang {

    private  Integer maHH ;
    private  Integer soluongban ;
    private String thangbanhang ;

    public DanhSachBanHang(Integer maHH, Integer soluongban) {
        this.maHH = maHH;
        this.soluongban = soluongban;

    }

    public DanhSachBanHang() {

    }
}
