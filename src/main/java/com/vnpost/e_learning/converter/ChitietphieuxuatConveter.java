/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;


import com.vnpost.e_learning.dto.ChitietphieuxuatDTO;
import com.vnpost.e_learning.entities.ChitietphieuThu;
import com.vnpost.e_learning.entities.Chitietphieuxuat;
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
public class ChitietphieuxuatConveter {

    @Autowired
    private ModelMapper modelMapper;


    public ChitietphieuxuatDTO convertToDTO(Object entity) {
        ChitietphieuxuatDTO dto = modelMapper.map(entity, ChitietphieuxuatDTO.class);
        return dto;
    }


    public ChitietphieuThu convertToEntity(Object dto) {
        ChitietphieuThu entity = modelMapper.map(dto, ChitietphieuThu.class);
        return entity;
    }



}
