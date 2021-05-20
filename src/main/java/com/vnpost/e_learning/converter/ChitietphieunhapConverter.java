/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;



import com.vnpost.e_learning.dto.ChitietphieunhapDTO;
import com.vnpost.e_learning.entities.ChitietphieuThu;
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
public class ChitietphieunhapConverter {

    @Autowired
    private ModelMapper modelMapper;


    public ChitietphieunhapDTO convertToDTO(Object entity) {
        ChitietphieunhapDTO dto = modelMapper.map(entity, ChitietphieunhapDTO.class);
        return dto;
    }


    public ChitietphieuThu convertToEntity(Object dto) {
        ChitietphieuThu entity = modelMapper.map(dto, ChitietphieuThu.class);
        return entity;
    }



}
