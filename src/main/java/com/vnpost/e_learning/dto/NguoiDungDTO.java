/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import com.vnpost.e_learning.entities.ChamCong;
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
public class NguoiDungDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String maND;

    private String fullName;

    private String image;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation

    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation

    private String email;

    private Integer kHVip;

    private Integer role;

    private String chucdanh;

    private String username;

    private String password;

    private List<ThueDTO> ThueList;

    private List<LuongThuongDTO> luongThuongList;

    private List<ChamCong> chamCongList;

    private List<HeSoLuongDTO> heSoLuongList;

    private List<PhieuThuDTO> phieuThuList;

    private List<HoaDonDTO> hoaDonList;

//    private List<PhieuThuDTO> phieuThuList;
//
//    private List<PhieuThuDTO> phieuThuList;

    private List<PhieuChiDTO> phieuChiList;


    private NhomKhachHangDTO nhomKhachHangID;


}
