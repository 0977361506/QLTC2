package com.vnpost.e_learning.bean;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BaoCaoKho {
    private  Integer maHH ;
    private  String maCode ;
    private String tenHH ;
    private Integer soluongnhap;
    private  Integer soluongxuat ;
    private  Integer soluongbanra ;
    private Integer soluongconlai ;

    private  Float gia ;
    private Float giamgia ;

    public BaoCaoKho(Integer maHH, String maCode, String tenHH,
                     Integer soluongnhap, Integer soluongxuat, Integer soluongbanra ,Integer soluongconlai) {
        this.maHH = maHH;
        this.maCode = maCode;
        this.tenHH = tenHH;
        this.soluongnhap = soluongnhap;
        this.soluongxuat = soluongxuat;
        this.soluongbanra = soluongbanra;
        this.soluongconlai = soluongconlai ;
    }

    public BaoCaoKho() {

    }
}
