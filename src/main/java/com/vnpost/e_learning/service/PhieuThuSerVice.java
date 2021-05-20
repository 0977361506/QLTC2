package com.vnpost.e_learning.service;

import com.vnpost.e_learning.converter.KhoConverter;
import com.vnpost.e_learning.converter.PhieuThuConverter;
import com.vnpost.e_learning.dto.KhoDTO;
import com.vnpost.e_learning.dto.PhieuThuDTO;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.repository.KhoRepository;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhieuThuSerVice {
    @Autowired
    private PhieuThuRepository phieuThuRepository ;
    @Autowired
    private PhieuThuConverter phieuThuConverter ;
    public List<PhieuThuDTO> findAll(){
        return phieuThuRepository.findAll().stream().map(item->phieuThuConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public PhieuThuDTO findByID(Integer id){
        return  phieuThuConverter.convertToDTO(phieuThuRepository.findById(id).get());
    }
    public void save(PhieuThuDTO hangHoaDTO){
        PhieuThu hangHoa = phieuThuConverter.convertToEntity(hangHoaDTO);
        phieuThuRepository.save(hangHoa);
    }
}
