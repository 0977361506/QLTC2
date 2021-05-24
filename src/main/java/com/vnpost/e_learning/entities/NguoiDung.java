/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "NguoiDung")

public class NguoiDung implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "MaND")
    private String maND;
    @Size(max = 255)
    @Column(name = "FullName")
    private String fullName;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "Email")
    private String email;
    @Column(name = "KHVip")
    private Integer kHVip;
    @Column(name = "Role")
    private Integer role;
    @Size(max = 255)
    @Column(name = "Chucdanh")
    private String chucdanh;
    @Size(max = 255)
    @Column(name = "Username")
    private String username;
    @Size(max = 255)
    @Column(name = "Password")
    private String password;
    private Integer quyen;

    public Integer getkHVip() {
        return kHVip;
    }

    public Integer getQuyen() {
        return quyen;
    }

    public void setkHVip(Integer kHVip) {
        this.kHVip = kHVip;
    }

    public void setQuyen(Integer quyen) {
        this.quyen = quyen;
    }

    private  Integer trangthai ;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<Thue> ThueList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<LuongThuong> luongThuongList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<ChamCong> chamCongList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<HeSoLuong> heSoLuongList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<PhieuThu> phieuThuList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<HoaDon> hoaDonList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<PhieuThu> phieuThuList;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDungID")
//    private List<PhieuChi> phieuChiList;
//    @JoinColumn(name = "NhomKhachHangID", referencedColumnName = "ID")
    @JsonIgnore
    @ManyToOne
    private NhomKhachHang nhomKhachHangID;

    public NguoiDung() {
    }



    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

    public NguoiDung(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getKHVip() {
        return kHVip;
    }

    public void setKHVip(Integer kHVip) {
        this.kHVip = kHVip;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getChucdanh() {
        return chucdanh;
    }

    public void setChucdanh(String chucdanh) {
        this.chucdanh = chucdanh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @XmlTransient
//    public List<Thue> getThueList() {
//        return ThueList;
//    }
//
//    public void setThueList(List<Thue> ThueList) {
//        this.ThueList = ThueList;
//    }
//
//    @XmlTransient
//    public List<LuongThuong> getLuongThuongList() {
//        return luongThuongList;
//    }
//
//    public void setLuongThuongList(List<LuongThuong> luongThuongList) {
//        this.luongThuongList = luongThuongList;
//    }
//
//    @XmlTransient
//    public List<ChamCong> getChamCongList() {
//        return chamCongList;
//    }
//
//    public void setChamCongList(List<ChamCong> chamCongList) {
//        this.chamCongList = chamCongList;
//    }
//
//    @XmlTransient
//    public List<HeSoLuong> getHeSoLuongList() {
//        return heSoLuongList;
//    }
//
//    public void setHeSoLuongList(List<HeSoLuong> heSoLuongList) {
//        this.heSoLuongList = heSoLuongList;
//    }
//
//    @XmlTransient
//    public List<PhieuThu> getPhieuThuList() {
//        return phieuThuList;
//    }
//
//    public void setPhieuThuList(List<PhieuThu> phieuThuList) {
//        this.phieuThuList = phieuThuList;
//    }
//
//    @XmlTransient
//    public List<HoaDon> getHoaDonList() {
//        return hoaDonList;
//    }
//
//    public void setHoaDonList(List<HoaDon> hoaDonList) {
//        this.hoaDonList = hoaDonList;
//    }
//
//
//
//    @XmlTransient
//    public List<PhieuChi> getPhieuChiList() {
//        return phieuChiList;
//    }
//
//    public void setPhieuChiList(List<PhieuChi> phieuChiList) {
//        this.phieuChiList = phieuChiList;
//    }

    public NhomKhachHang getNhomKhachHangID() {
        return nhomKhachHangID;
    }

    public void setNhomKhachHangID(NhomKhachHang nhomKhachHangID) {
        this.nhomKhachHangID = nhomKhachHangID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NguoiDung)) {
            return false;
        }
        NguoiDung other = (NguoiDung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.NguoiDung[ id=" + id + " ]";
    }

}
