/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.PhieuChiDTO;
import com.vnpost.e_learning.dto.PhieuThuDTO;
import com.vnpost.e_learning.entities.PhieuChi;
import com.vnpost.e_learning.entities.PhieuThu;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
@Component
public class PhieuNhapConverter {

    @Autowired
    private ModelMapper modelMapper;


    public PhieuThuDTO convertToDTO(Object entity) {
        PhieuThuDTO dto = modelMapper.map(entity, PhieuThuDTO.class);
        return dto;
    }


    public PhieuThu convertToEntity(Object dto) {
        PhieuThu entity = modelMapper.map(dto, PhieuThu.class);
        return entity;
    }

}
