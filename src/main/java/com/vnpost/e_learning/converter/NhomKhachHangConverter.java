/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vnpost.e_learning.converter;

import com.vnpost.e_learning.dto.NhaCungCapDTO;
import com.vnpost.e_learning.dto.NhomKhachHangDTO;
import com.vnpost.e_learning.entities.NhaCungCap;
import com.vnpost.e_learning.entities.NhomKhachHang;
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
public class NhomKhachHangConverter{

    @Autowired
    private ModelMapper modelMapper;


    public NhomKhachHangDTO convertToDTO(Object entity) {
        NhomKhachHangDTO dto = modelMapper.map(entity, NhomKhachHangDTO.class);
        return dto;
    }


    public NhomKhachHang convertToEntity(Object dto) {
        NhomKhachHang entity = modelMapper.map(dto, NhomKhachHang.class);
        return entity;
    }
}
