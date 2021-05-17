/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Chitietphieunhap")

public class Chitietphieunhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Soluong")
    private int soluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Giamgia")
    private float giamgia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private float gia;
    @JoinColumn(name = "HangHoaID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HangHoa hangHoaID;
    @JoinColumn(name = "PhieunhapID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PhieuNhap phieunhapID;

    public Chitietphieunhap() {
    }

    public Chitietphieunhap(Integer id) {
        this.id = id;
    }

    public Chitietphieunhap(Integer id, int soluong, float giamgia, float gia) {
        this.id = id;
        this.soluong = soluong;
        this.giamgia = giamgia;
        this.gia = gia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(float giamgia) {
        this.giamgia = giamgia;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public HangHoa getHangHoaID() {
        return hangHoaID;
    }

    public void setHangHoaID(HangHoa hangHoaID) {
        this.hangHoaID = hangHoaID;
    }

    public PhieuNhap getPhieunhapID() {
        return phieunhapID;
    }

    public void setPhieunhapID(PhieuNhap phieunhapID) {
        this.phieunhapID = phieunhapID;
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
        if (!(object instanceof Chitietphieunhap)) {
            return false;
        }
        Chitietphieunhap other = (Chitietphieunhap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Chitietphieunhap[ id=" + id + " ]";
    }
    
}
