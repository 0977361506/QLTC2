package com.vnpost.e_learning.service;

import com.vnpost.e_learning.converter.GiaConverter;
import com.vnpost.e_learning.dto.GiaDTO;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.repository.GiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GiaService {
    @Autowired
    private GiaRepository giaRepository ;
    @Autowired
    private GiaConverter giaConverter ;
    public List<GiaDTO> findAll(){
        return giaRepository.findAll().stream().map(item->giaConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public GiaDTO findByID(Integer id){
        return  giaConverter.convertToDTO(giaRepository.findById(id).get());
    }
    public void save(GiaDTO hangHoaDTO){
        Gia hangHoa = giaConverter.convertToEntity(hangHoaDTO);
        giaRepository.save(hangHoa);

    }
}
