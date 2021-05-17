/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.GiaDTO;
import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.entities.HangHoa;
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
public class HangHoaConverter {
    @Autowired
    private ModelMapper modelMapper;


    public HangHoaDTO convertToDTO(Object entity) {
        HangHoaDTO dto = modelMapper.map(entity, HangHoaDTO.class);
        return dto;
    }


    public HangHoa convertToEntity(Object dto) {
        HangHoa entity = modelMapper.map(dto, HangHoa.class);
        return entity;
    }

}
