/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.KhoDTO;
import com.vnpost.e_learning.dto.LuongThuongDTO;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.entities.LuongThuong;
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
public class LuongThuongConverter {

    @Autowired
    private ModelMapper modelMapper;


    public LuongThuongDTO convertToDTO(Object entity) {
        LuongThuongDTO dto = modelMapper.map(entity, LuongThuongDTO.class);
        return dto;
    }


    public LuongThuong convertToEntity(Object dto) {
        LuongThuong entity = modelMapper.map(dto, LuongThuong.class);
        return entity;
    }

}
