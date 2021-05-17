/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class PhieuChiDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String maPhieuChi;

    private String ghichu;

    private float sotien;

    private String noidungchi;

    private String ngaytao;

    private String doituongthanhtoan;

    private String soTK;

    private String tenNguoiNhan;


    private NguoiDungDTO nguoiDungID;


}
