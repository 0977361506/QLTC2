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
public class PhieuNhapDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String maPhieu;

    private String ngaytao;

    private String ghichu;

    private NguoiDungDTO nguoiDungID;

    private NhaCungCapDTO nhaCungCapID;

//    private List<ChitietphieuThuDTO> chitietphieuThuList;

}
