package com.vnpost.e_learning.service;

import com.vnpost.e_learning.entities.DanhMucKho;
import com.vnpost.e_learning.repository.DanhMucKhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucKhoService {
    @Autowired
    private DanhMucKhoRepository danhMucKhoRepository ;

    public List<DanhMucKho> findAll(){
        return danhMucKhoRepository.findAll();
    }

    public DanhMucKho findByID(Integer id){
        return  danhMucKhoRepository.findById(id).get();
    }
    public void save(DanhMucKho hangHoaDTO){
        DanhMucKho hangHoa = danhMucKhoRepository.save(hangHoaDTO);

    }
}
