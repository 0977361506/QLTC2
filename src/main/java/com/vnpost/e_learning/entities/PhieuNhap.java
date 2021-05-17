/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

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
@Table(name = "PhieuNhap")
@Getter
@Setter

public class PhieuNhap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "MaPhieu")
    private String maPhieu;
    @Size(max = 10)
    @Column(name = "Ngaytao")
    private String ngaytao;
    @Size(max = 255)
    @Column(name = "Ghichu")
    private String ghichu;

    @Column(name = "nguoi_dungid")
    private Integer maND;

    @Column(name = "nha_cung_capid")
    private  Integer maNCC ;
    
}
