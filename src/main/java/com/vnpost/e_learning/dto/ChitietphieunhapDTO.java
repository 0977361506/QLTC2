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
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class ChitietphieunhapDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private int soluong;

    private float giamgia;

    private float gia;

    private HangHoaDTO hangHoaID;

    private PhieuThuDTO phieuThuID;


}
