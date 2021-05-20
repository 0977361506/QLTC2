/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.HeSoLuongDTO;
import com.vnpost.e_learning.dto.HoaDonDTO;
import com.vnpost.e_learning.entities.HeSoLuong;
import com.vnpost.e_learning.entities.HoaDon;
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
public class HoaDonConverter {

    @Autowired
    private ModelMapper modelMapper;


    public HoaDonDTO convertToDTO(Object entity) {
        HoaDonDTO dto = modelMapper.map(entity, HoaDonDTO.class);
        return dto;
    }


    public HoaDon convertToEntity(Object dto) {
        HoaDon entity = modelMapper.map(dto, HoaDon.class);
        return entity;
    }

}
