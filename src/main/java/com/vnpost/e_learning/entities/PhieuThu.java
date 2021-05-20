/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.entities;

import lombok.Getter;
import lombok.Setter;

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
@Table(name = "PhieuThu")
@Getter
@Setter

public class PhieuThu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "MaPhieuThu")
    private String maPhieuThu;
    @Size(max = 255)
    @Column(name = "Ghichu")
    private String ghichu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sotien")
    private float sotien;
    @Size(max = 255)
    @Column(name = "DiachiThu")
    private String diachiThu;
    @Size(max = 255)
    @Column(name = "NoiidungThu")
    private String noiidungThu;
    @Size(max = 10)
    @Column(name = "Ngaytao")
    private String ngaytao;
    @Size(max = 255)
    @Column(name = "Tennguoinop")
    private String tennguoinop;
    @Size(max = 255)
    @Column(name = "SoTK")
    private String soTK;
    @Size(max = 255)
    @Column(name = "Doituong")
    private String doituong;

    @Column(name = "nguoi_dungid")
    private Integer maND;






    
}
