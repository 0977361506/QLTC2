/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import com.vnpost.e_learning.entities.ChamCong;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
@Getter
@Setter
public class ChiPhiDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String tenChiPhi;

    private String ngaytao;

    private String ghichu;

    private float sotien;


}