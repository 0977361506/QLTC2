/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.ChamCongDTO;
import com.vnpost.e_learning.dto.ChitiethoadonDTO;
import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Chitiethoadon;
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
public class ChitiethoadonConverter  {

    @Autowired
    private ModelMapper modelMapper;


    public ChitiethoadonDTO convertToDTO(Object entity) {
        ChitiethoadonDTO dto = modelMapper.map(entity, ChitiethoadonDTO.class);
        return dto;
    }


    public Chitiethoadon convertToEntity(Object dto) {
        Chitiethoadon entity = modelMapper.map(dto, Chitiethoadon.class);
        return entity;
    }


}
