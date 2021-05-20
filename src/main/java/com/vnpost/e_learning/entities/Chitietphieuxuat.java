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
@Table(name = "Chitietphieuxuat")

public class Chitietphieuxuat implements Serializable {

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
    @JoinColumn(name = "PhieuXuatID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PhieuXuat phieuXuatID;

    public Chitietphieuxuat() {
    }

    public Chitietphieuxuat(Integer id) {
        this.id = id;
    }

    public Chitietphieuxuat(Integer id, int soluong, float giamgia, float gia) {
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

    public PhieuXuat getPhieuXuatID() {
        return phieuXuatID;
    }

    public void setPhieuXuatID(PhieuXuat phieuXuatID) {
        this.phieuXuatID = phieuXuatID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "pojos.ChitietphieuXuat[ id=" + id + " ]";
    }
    
}
