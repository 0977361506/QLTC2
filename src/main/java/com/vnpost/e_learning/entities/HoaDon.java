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
@Table(name = "HoaDon")

public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "MaHD")
    private String maHD;
    @Size(max = 10)
    @Column(name = "Ngaytao")
    private String ngaytao;
    @Size(max = 255)
    @Column(name = "Ghichu")
    private String ghichu;
    @JoinColumn(name = "NguoiDungID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NguoiDung nguoiDungID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoaDonID")
    private List<Chitiethoadon> chitiethoadonList;

    public HoaDon() {
    }

    public HoaDon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public NguoiDung getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(NguoiDung nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
    }

    @XmlTransient
    public List<Chitiethoadon> getChitiethoadonList() {
        return chitiethoadonList;
    }

    public void setChitiethoadonList(List<Chitiethoadon> chitiethoadonList) {
        this.chitiethoadonList = chitiethoadonList;
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
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.HoaDon[ id=" + id + " ]";
    }
    
}
