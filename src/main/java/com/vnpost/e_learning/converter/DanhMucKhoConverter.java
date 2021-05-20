/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.DanhMucHangHoaDTO;
import com.vnpost.e_learning.dto.DanhMucKhoDTO;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.entities.DanhMucKho;
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
public class DanhMucKhoConverter {

    @Autowired
    private ModelMapper modelMapper;


    public DanhMucKhoDTO convertToDTO(Object entity) {
        DanhMucKhoDTO dto = modelMapper.map(entity, DanhMucKhoDTO.class);
        return dto;
    }


    public DanhMucKho convertToEntity(Object dto) {
        DanhMucKho entity = modelMapper.map(dto, DanhMucKho.class);
        return entity;
    }
}
