package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.BaoMat;
import com.vnpost.e_learning.repository.BaoMatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BaoMatApi {

    @Autowired
    BaoMatRepository baoMatRepository ;

    @GetMapping("/getAllByMaND/{idND}")
    public List<BaoMat> findAllByMaND(@PathVariable("idND") Integer idND){
        return baoMatRepository.findAllByMaND(idND);
    }

}
