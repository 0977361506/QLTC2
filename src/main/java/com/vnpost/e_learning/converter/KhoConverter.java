/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.HoaDonDTO;
import com.vnpost.e_learning.dto.KhoDTO;
import com.vnpost.e_learning.entities.HoaDon;
import com.vnpost.e_learning.entities.Kho;
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
public class KhoConverter {

    @Autowired
    private ModelMapper modelMapper;


    public KhoDTO convertToDTO(Object entity) {
        KhoDTO dto = modelMapper.map(entity, KhoDTO.class);
        return dto;
    }


    public Kho convertToEntity(Object dto) {
        Kho entity = modelMapper.map(dto, Kho.class);
        return entity;
    }
    
}
