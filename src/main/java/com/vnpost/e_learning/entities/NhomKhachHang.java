/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

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
@Table(name = "NhomKhachHang")

public class NhomKhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "TenNhom")
    private String tenNhom;
    @Size(max = 10)
    @Column(name = "Ngaytao")
    private String ngaytao;
    @OneToMany(mappedBy = "nhomKhachHangID")
    private List<NguoiDung> nguoiDungList;

    public NhomKhachHang() {
    }

    public NhomKhachHang(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    @XmlTransient
    public List<NguoiDung> getNguoiDungList() {
        return nguoiDungList;
    }

    public void setNguoiDungList(List<NguoiDung> nguoiDungList) {
        this.nguoiDungList = nguoiDungList;
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
        if (!(object instanceof NhomKhachHang)) {
            return false;
        }
        NhomKhachHang other = (NhomKhachHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.NhomKhachHang[ id=" + id + " ]";
    }
    
}
