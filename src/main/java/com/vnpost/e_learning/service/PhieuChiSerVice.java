package com.vnpost.e_learning.service;

import com.vnpost.e_learning.converter.PhieuChiConverter;
import com.vnpost.e_learning.converter.PhieuThuConverter;
import com.vnpost.e_learning.dto.PhieuChiDTO;
import com.vnpost.e_learning.dto.PhieuThuDTO;
import com.vnpost.e_learning.entities.PhieuChi;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.repository.PhieuChiRepository;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhieuChiSerVice {
    @Autowired
    private PhieuChiRepository phieuChiRepository ;
    @Autowired
    private PhieuChiConverter phieuChiConverter ;
    public List<PhieuChiDTO> findAll(){
        return phieuChiRepository.findAll().stream().map(item->phieuChiConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public PhieuChiDTO findByID(Integer id){
        return  phieuChiConverter.convertToDTO(phieuChiRepository.findById(id).get());
    }
    public void save(PhieuChiDTO hangHoaDTO){
        PhieuChi hangHoa = phieuChiConverter.convertToEntity(hangHoaDTO);

        phieuChiRepository.save(hangHoa);

    }
}
