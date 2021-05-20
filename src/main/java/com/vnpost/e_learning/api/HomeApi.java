package com.vnpost.e_learning.api;

import com.vnpost.e_learning.bean.CartBean;
import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.service.HangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeApi {

    @Autowired
    private HangHoaService hangHoaService ;
    @Autowired
    private CartBean cartBean ;
    @RequestMapping("/hanghoa")
    public List<HangHoaDTO> getList(){
        cartBean.removeAll();
        return hangHoaService.findAll();
    }
}
