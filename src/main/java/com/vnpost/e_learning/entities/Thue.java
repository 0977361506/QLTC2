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
@Table(name = "Thue")

public class Thue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "MaThue")
    private String maThue;
    @Size(max = 255)
    @Column(name = "TenThue")
    private String tenThue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Giatri")
    private float giatri;
    @JoinColumn(name = "DanhMucThueID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private DanhMucThue danhMucThueID;
    @JoinColumn(name = "NguoiDungID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NguoiDung nguoiDungID;

    public Thue() {
    }

    public Thue(Integer id) {
        this.id = id;
    }

    public Thue(Integer id, float giatri) {
        this.id = id;
        this.giatri = giatri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaThue() {
        return maThue;
    }

    public void setMaThue(String maThue) {
        this.maThue = maThue;
    }

    public String getTenThue() {
        return tenThue;
    }

    public void setTenThue(String tenThue) {
        this.tenThue = tenThue;
    }

    public float getGiatri() {
        return giatri;
    }

    public void setGiatri(float giatri) {
        this.giatri = giatri;
    }

    public DanhMucThue getDanhMucThueID() {
        return danhMucThueID;
    }

    public void setDanhMucThueID(DanhMucThue danhMucThueID) {
        this.danhMucThueID = danhMucThueID;
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
        if (!(object instanceof Thue)) {
            return false;
        }
        Thue other = (Thue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojos.Thue[ id=" + id + " ]";
    }
    
}
