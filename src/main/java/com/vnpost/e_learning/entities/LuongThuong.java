/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "LuongThuong")

public class LuongThuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Ghichu")
    private String ghichu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LuongThuong")
    private float luongThuong;
    @JoinColumn(name = "NguoiDungID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NguoiDung nguoiDungID;

    public LuongThuong() {
    }

    public LuongThuong(Integer id) {
        this.id = id;
    }

    public LuongThuong(Integer id, float luongThuong) {
        this.id = id;
        this.luongThuong = luongThuong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public float getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(float luongThuong) {
        this.luongThuong = luongThuong;
    }

    public NguoiDung getNguoiDungID() {
        return nguoiDungID;
    }

    public void setNguoiDungID(NguoiDung nguoiDungID) {
        this.nguoiDungID = nguoiDungID;
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
        if (!(object instanceof LuongThuong)) {
            return false;
        }
        LuongThuong other = (LuongThuong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.LuongThuong[ id=" + id + " ]";
    }
    
}
