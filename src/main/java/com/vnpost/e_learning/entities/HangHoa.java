/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "HangHoa")
@Getter
@Setter
public class HangHoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHH")
    private int maHH;
    @Size(max = 255)
    @Column(name = "TenHH")
    private String tenHH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Giamgia")
    private float giamgia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "New")
    private int new1;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;
    @Size(max = 1073741823)
    @Column(name = "Mieuta")
    private String mieuta;
    private  Integer soluong ;
    @Column(name = "gia")
    private float gia ;

    @Column(name = "danh_muc_hang_hoaid")
    private Integer danh_muc_hang_hoaid ;

//    @JsonIgnore
//    @JoinColumn(name = "DanhMucHangHoaID", referencedColumnName = "ID")
//    @ManyToOne(optional = false)
//    private DanhMucHangHoa danhMucHangHoaID;

    
}
