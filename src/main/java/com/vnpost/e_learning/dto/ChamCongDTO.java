/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.dto;

import com.vnpost.e_learning.entities.ChiPhi;
import com.vnpost.e_learning.entities.NguoiDung;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */

@Getter
@Setter
public class ChamCongDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String ghichu;

    private Integer songaylamviec;

    private Integer nguoiDungID;


}
