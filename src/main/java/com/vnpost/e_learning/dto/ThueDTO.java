/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class ThueDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String maThue;

    private String tenThue;

    private float giatri;

    private DanhMucThueDTO danhMucThueID;

    private NguoiDungDTO nguoiDungID;


}
