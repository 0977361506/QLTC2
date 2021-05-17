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
@Table(name = "Chitiethoadon")

public class Chitiethoadon implements Serializable {

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
    @Column(name = "Gia")
    private float gia;
    @Column(name = "Giamgia")
    private Integer giamgia;
    @JoinColumn(name = "HangHoaID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HangHoa hangHoaID;
    @JoinColumn(name = "HoaDonID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HoaDon hoaDonID;

    public Chitiethoadon() {
    }

    public Chitiethoadon(Integer id) {
        this.id = id;
    }

    public Chitiethoadon(Integer id, int soluong, float gia) {
        this.id = id;
        this.soluong = soluong;
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

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public Integer getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(Integer giamgia) {
        this.giamgia = giamgia;
    }

    public HangHoa getHangHoaID() {
        return hangHoaID;
    }

    public void setHangHoaID(HangHoa hangHoaID) {
        this.hangHoaID = hangHoaID;
    }

    public HoaDon getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(HoaDon hoaDonID) {
        this.hoaDonID = hoaDonID;
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
        if (!(object instanceof Chitiethoadon)) {
            return false;
        }
        Chitiethoadon other = (Chitiethoadon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Chitiethoadon[ id=" + id + " ]";
    }
    
}
