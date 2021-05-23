package com.vnpost.e_learning.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class BaoCaoLuong {
    // select nd.full_name as hoten , nd.mand , nd.chucdanh ,
    //thue.ma_thue  as mathue , thue.ten_thue as tenthue , thue.giatri as giatrithue ,
    //hsl.heso , luongthuong.luong_thuong as luongcoban , cc.songaylamviec , cc.thang as thanglamviec
    private String hoten ;
    private String mand ;
    private  String chucdanh ;
    private String mathue ;
    private String tenthue ;
    private Double giatrithue ;
    private  Double heso ;
    private  Double luongcoban ;
    private  Double songaylamviec ;
    private  String thanglamviec ;
    private  Integer idNV ;
    public BaoCaoLuong(String hoten, String mand,
                       String chucdanh, String mathue,
                       String tenthue, Double giatrithue,
                       Double heso, Double luongcoban,
                       Double songaylamviec, String thanglamviec) {
        this.hoten = hoten;
        this.mand = mand;
        this.chucdanh = chucdanh;
        this.mathue = mathue;
        this.tenthue = tenthue;
        this.giatrithue = giatrithue;
        this.heso = heso;
        this.luongcoban = luongcoban;
        this.songaylamviec = songaylamviec;
        this.thanglamviec = thanglamviec;
    }

    public BaoCaoLuong(String hoten, String mand,
                       String chucdanh, String mathue,
                       String tenthue, Double giatrithue,
                       Double heso, Double luongcoban,
                       Double songaylamviec, String thanglamviec,Integer idNV) {
        this.hoten = hoten;
        this.mand = mand;
        this.chucdanh = chucdanh;
        this.mathue = mathue;
        this.tenthue = tenthue;
        this.giatrithue = giatrithue;
        this.heso = heso;
        this.luongcoban = luongcoban;
        this.songaylamviec = songaylamviec;
        this.thanglamviec = thanglamviec;
        this.idNV = idNV ;
    }

    public BaoCaoLuong() {

    }
}
