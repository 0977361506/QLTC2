package com.vnpost.e_learning.service;

import com.vnpost.e_learning.converter.HangHoaConverter;
import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.repository.HanghoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HangHoaService {
    @Autowired
    private HanghoaRepository danhmucHangHoaRepository ;
    @Autowired
    private HangHoaConverter hangHoaConverter ;
    public List<HangHoaDTO> findAll(){
        return danhmucHangHoaRepository.findAll().stream().map(item->hangHoaConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    //'%f%'

    public List<HangHoaDTO> timkiem(String name){
        return danhmucHangHoaRepository.timkiem("%"+name+"%").stream().map(item->hangHoaConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }


    public HangHoaDTO findByID(Integer maHH){
        if(danhmucHangHoaRepository.findByMaHH(maHH).size()>0) return hangHoaConverter.convertToDTO(
                danhmucHangHoaRepository.findByMaHH(maHH).get(0));
        return  null;
    }
    public void save(HangHoaDTO hangHoaDTO){
      //  HangHoa hangHoa = hangHoaConverter.convertToEntity(hangHoaDTO);
        danhmucHangHoaRepository.saveHangHoa(
                hangHoaDTO.getGiamgia(),hangHoaDTO.getGia(),hangHoaDTO.getImage(),hangHoaDTO.getMaHH(),
                hangHoaDTO.getMieuta(),hangHoaDTO.getNew1(),hangHoaDTO.getDanh_muc_hang_hoaid(),hangHoaDTO.getTenHH(),
                hangHoaDTO.getMaHH()
        );

    }

    public void add(HangHoaDTO hangHoaDTO){
        //  HangHoa hangHoa = hangHoaConverter.convertToEntity(hangHoaDTO);
        System.out.println(hangHoaDTO.getMieuta());
        danhmucHangHoaRepository.add(
                hangHoaDTO.getGiamgia(),hangHoaDTO.getGia(),hangHoaDTO.getImage(),hangHoaDTO.getMaHH(),
                hangHoaDTO.getMieuta(),hangHoaDTO.getNew1(),hangHoaDTO.getDanh_muc_hang_hoaid(),hangHoaDTO.getTenHH()

        );

    }
}
