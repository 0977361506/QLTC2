/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.NhomKhachHangDTO;
import com.vnpost.e_learning.dto.PhieuChiDTO;
import com.vnpost.e_learning.entities.NhomKhachHang;
import com.vnpost.e_learning.entities.PhieuChi;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
@Component
public class PhieuChiConverter {

    @Autowired
    private ModelMapper modelMapper;


    public PhieuChiDTO convertToDTO(Object entity) {
        PhieuChiDTO dto = modelMapper.map(entity, PhieuChiDTO.class);
        return dto;
    }


    public PhieuChi convertToEntity(Object dto) {
        PhieuChi entity = modelMapper.map(dto, PhieuChi.class);
        return entity;
    }

}
