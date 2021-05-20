/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.DanhMucThueDTO;
import com.vnpost.e_learning.dto.GiaDTO;
import com.vnpost.e_learning.entities.DanhMucThue;
import com.vnpost.e_learning.entities.Gia;
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
public class GiaConverter {

    @Autowired
    private ModelMapper modelMapper;


    public GiaDTO convertToDTO(Object entity) {
        GiaDTO dto = modelMapper.map(entity, GiaDTO.class);
        return dto;
    }


    public Gia convertToEntity(Object dto) {
        Gia entity = modelMapper.map(dto, Gia.class);
        return entity;
    }

    
}
