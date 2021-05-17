/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.dto.HeSoLuongDTO;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.entities.HeSoLuong;
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
public class HeSoLuongConverter  {
    @Autowired
    private ModelMapper modelMapper;


    public HeSoLuongDTO convertToDTO(Object entity) {
        HeSoLuongDTO dto = modelMapper.map(entity, HeSoLuongDTO.class);
        return dto;
    }


    public HeSoLuong convertToEntity(Object dto) {
        HeSoLuong entity = modelMapper.map(dto, HeSoLuong.class);
        return entity;
    }

}
