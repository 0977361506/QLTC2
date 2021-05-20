/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.NguoiDungDTO;
import com.vnpost.e_learning.dto.NhaCungCapDTO;
import com.vnpost.e_learning.entities.NguoiDung;
import com.vnpost.e_learning.entities.NhaCungCap;
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
public class NhaCungCapConverter  {
    @Autowired
    private ModelMapper modelMapper;


    public NhaCungCapDTO convertToDTO(Object entity) {
        NhaCungCapDTO dto = modelMapper.map(entity, NhaCungCapDTO.class);
        return dto;
    }


    public NhaCungCap convertToEntity(Object dto) {
        NhaCungCap entity = modelMapper.map(dto, NhaCungCap.class);
        return entity;
    }
}
