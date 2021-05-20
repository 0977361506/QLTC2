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
@Table(name = "HeSoLuong")

public class HeSoLuong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Heso")
    private float heso;
    @JoinColumn(name = "NguoiDungID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NguoiDung nguoiDungID;

    public HeSoLuong() {
    }

    public HeSoLuong(Integer id) {
        this.id = id;
    }

    public HeSoLuong(Integer id, float heso) {
        this.id = id;
        this.heso = heso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getHeso() {
        return heso;
    }

    public void setHeso(float heso) {
        this.heso = heso;
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
        if (!(object instanceof HeSoLuong)) {
            return false;
        }
        HeSoLuong other = (HeSoLuong) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.HeSoLuong[ id=" + id + " ]";
    }
    
}
