package com.vnpost.e_learning.service;

import com.vnpost.e_learning.converter.DanhMucHangHoaConverter;
import com.vnpost.e_learning.dto.DanhMucHangHoaDTO;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.repository.DanhmucHangHoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DanhMucHangHoaService {
    @Autowired
    private DanhmucHangHoaRepository danhmucdanhmucHangHoaRepository ;
    @Autowired
    private DanhMucHangHoaConverter danhMucHangHoaConverter ;
    public List<DanhMucHangHoaDTO> findAll(){
        return danhmucdanhmucHangHoaRepository.findAll().stream().map(item->danhMucHangHoaConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public DanhMucHangHoaDTO findByID(Integer id){
        return  danhMucHangHoaConverter.convertToDTO(danhmucdanhmucHangHoaRepository.findById(id).get());
    }
    public void save(DanhMucHangHoaDTO hangHoaDTO){
        DanhMucHangHoa hangHoa = danhMucHangHoaConverter.convertToEntity(hangHoaDTO);
        danhmucdanhmucHangHoaRepository.save(hangHoa);

    }
}
