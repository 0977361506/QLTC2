package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.DaiLy;
import com.vnpost.e_learning.entities.NhaCungCap;
import com.vnpost.e_learning.repository.DaiLyRepository;
import com.vnpost.e_learning.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NhaCungCapApi {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository ;
    @Autowired
    private DaiLyRepository daiLyRepository ;

    @GetMapping("/nhacungcap")
    public List<NhaCungCap> getAll(){
        return nhaCungCapRepository.findAll();
    }


    @GetMapping("/daily")
    public List<DaiLy> finaLL(){
        return daiLyRepository.findAll();
    }
}
