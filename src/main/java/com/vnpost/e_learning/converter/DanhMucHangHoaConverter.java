/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.DaiLyDTO;
import com.vnpost.e_learning.dto.DanhMucHangHoaDTO;
import com.vnpost.e_learning.entities.DaiLy;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
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
public class DanhMucHangHoaConverter {

    @Autowired
    private ModelMapper modelMapper;


    public DanhMucHangHoaDTO convertToDTO(Object entity) {
        DanhMucHangHoaDTO dto = modelMapper.map(entity, DanhMucHangHoaDTO.class);
        return dto;
    }


    public DanhMucHangHoa convertToEntity(Object dto) {
        DanhMucHangHoa entity = modelMapper.map(dto, DanhMucHangHoa.class);
        return entity;
    }


}
