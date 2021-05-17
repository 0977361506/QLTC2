package com.vnpost.e_learning.service;

import com.vnpost.e_learning.converter.GiaConverter;
import com.vnpost.e_learning.converter.KhoConverter;
import com.vnpost.e_learning.dto.GiaDTO;
import com.vnpost.e_learning.dto.KhoDTO;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.repository.GiaRepository;
import com.vnpost.e_learning.repository.KhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhoService {
    @Autowired
    private KhoRepository khoRepository ;
    @Autowired
    private KhoConverter khoConverter ;
    public List<KhoDTO> findAll(){
        return khoRepository.findAll().stream().map(item->khoConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public KhoDTO findByID(Integer id){
        return  khoConverter.convertToDTO(khoRepository.findById(id).get());
    }
    public void save(KhoDTO hangHoaDTO){
        Kho hangHoa = khoConverter.convertToEntity(hangHoaDTO);
        khoRepository.save(hangHoa);

    }
}
