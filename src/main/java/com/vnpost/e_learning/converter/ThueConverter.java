/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.PhieuThuDTO;
import com.vnpost.e_learning.dto.ThueDTO;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.entities.Thue;
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
public class ThueConverter {
    @Autowired
    private ModelMapper modelMapper;


    public ThueDTO convertToDTO(Object entity) {
        ThueDTO dto = modelMapper.map(entity, ThueDTO.class);
        return dto;
    }


    public Thue convertToEntity(Object dto) {
        Thue entity = modelMapper.map(dto, Thue.class);
        return entity;
    }


}
