/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.ChamCongDTO;
import com.vnpost.e_learning.entities.ChamCong;
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
public class ChamCongConverter  {
    @Autowired
    private ModelMapper modelMapper;


    public ChamCongDTO convertToDTO(Object entity) {
        ChamCongDTO dto = modelMapper.map(entity, ChamCongDTO.class);
        return dto;
    }


    public ChamCong convertToEntity(Object dto) {
        ChamCong entity = modelMapper.map(dto, ChamCong.class);
        return entity;
    }

}
