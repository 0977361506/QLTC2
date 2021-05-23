package com.vnpost.e_learning.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class BangCongTheoNgay {
//     "id" : res.id,
//            "manv" : maid ,
//            "hoten" :  hoten,
//            "songaylamviec" : songaylamviec ,
//            "ngaylamviec" : ngaylamviec
//    pri

    private  Integer id ; // id nhân viên
    private String manv ;
    private  String hoten ;
    private Double songaylamviec ;
    private String ngaylamviec;
}
