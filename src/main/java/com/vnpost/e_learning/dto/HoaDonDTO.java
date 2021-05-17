/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class HoaDonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String maHD;

    private String ngaytao;

    private String ghichu;

    private NguoiDungDTO nguoiDungID;


    private List<ChitiethoadonDTO> chitiethoadonList;

}
