/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.DaiLyDTO;
import com.vnpost.e_learning.entities.ChitietphieuThu;
import com.vnpost.e_learning.entities.DaiLy;
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
public class DaiLyDTOConverter {

    @Autowired
    private ModelMapper modelMapper;


    public DaiLyDTO convertToDTO(Object entity) {
        DaiLyDTO dto = modelMapper.map(entity, DaiLyDTO.class);
        return dto;
    }


    public DaiLy convertToEntity(Object dto) {
        DaiLy entity = modelMapper.map(dto, DaiLy.class);
        return entity;
    }


}
