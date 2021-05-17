/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.DanhMucKhoDTO;
import com.vnpost.e_learning.dto.DanhMucThueDTO;
import com.vnpost.e_learning.entities.DanhMucKho;
import com.vnpost.e_learning.entities.DanhMucThue;
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
public class DanhMucThueConverter {

    @Autowired
    private ModelMapper modelMapper;


    public DanhMucThueDTO convertToDTO(Object entity) {
        DanhMucThueDTO dto = modelMapper.map(entity, DanhMucThueDTO.class);
        return dto;
    }


    public DanhMucThue convertToEntity(Object dto) {
        DanhMucThue entity = modelMapper.map(dto, DanhMucThue.class);
        return entity;
    }
}
