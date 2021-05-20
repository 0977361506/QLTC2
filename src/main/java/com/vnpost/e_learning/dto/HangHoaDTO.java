/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class HangHoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private int maHH;

    private String tenHH;

    private float giamgia;

    private int new1;

    private String image;

    private String mieuta;

    private float gia ;
    private  Integer danh_muc_hang_hoaid ;

//    private List<ChitietphieuThuDTO> chitietphieuThuList;

//    private DanhMucHangHoaDTO danhMucHangHoaID;
//
//    private List<ChitiethoadonDTO> chitiethoadonList;

//    private List<ChitietphieuThuDTO> chitietphieuThuList;
//
//    private List<GiaDTO> giaList;

    
}
