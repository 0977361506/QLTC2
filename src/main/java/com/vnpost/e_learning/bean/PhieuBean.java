package com.vnpost.e_learning.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
public class PhieuBean implements Serializable {
    //select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,
    //ncc.tenncc  , ncc.diachi
    private String maphieu ;
    private  String ghichu;
    private  Integer trangthai ;
    private  String nguoitao ;
    private  String tenncc ;
    private  String diachi ;
    private  String ngaytao ;
    private  Integer id ;

    public PhieuBean(String maphieu, String ghichu, Integer trangthai,
                     String nguoitao, String tenncc, String diachi,String ngaytao,Integer id) {
        this.maphieu = maphieu;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
        this.nguoitao = nguoitao;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.ngaytao = ngaytao ;
        this.id = id ;
    }

    public PhieuBean() {

    }




}
