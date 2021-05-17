/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.ChamCongDTO;
import com.vnpost.e_learning.dto.ChiPhiDTO;
import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.ChiPhi;
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
public class ChiPhiConverter {

    @Autowired
    private ModelMapper modelMapper;


    public ChiPhiDTO convertToDTO(Object entity) {
        ChiPhiDTO dto = modelMapper.map(entity, ChiPhiDTO.class);
        return dto;
    }


    public ChiPhi convertToEntity(Object dto) {
        ChiPhi entity = modelMapper.map(dto, ChiPhi.class);
        return entity;
    }

}
