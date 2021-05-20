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
@Table(name = "DaiLy")

public class DaiLy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "MaDL")
    private String maDL;
    @Size(max = 255)
    @Column(name = "TenDL")
    private String tenDL;
    @Size(max = 255)
    @Column(name = "Diachi")
    private String diachi;
    @Size(max = 255)
    @Column(name = "Sdt")
    private String sdt;


    public DaiLy() {
    }

    public DaiLy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaDL() {
        return maDL;
    }

    public void setMaDL(String maDL) {
        this.maDL = maDL;
    }

    public String getTenDL() {
        return tenDL;
    }

    public void setTenDL(String tenDL) {
        this.tenDL = tenDL;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
        if (!(object instanceof DaiLy)) {
            return false;
        }
        DaiLy other = (DaiLy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.DaiLy[ id=" + id + " ]";
    }
    
}
