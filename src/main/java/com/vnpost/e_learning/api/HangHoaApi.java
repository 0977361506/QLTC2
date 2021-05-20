package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.service.HangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HangHoaApi {
    @Autowired
    private HangHoaService hangHoaService ;

    @RequestMapping("/hanghoa/{id}")
    public HangHoaDTO getList(@PathVariable("id") Integer id){
        return hangHoaService.findByID(id);
    }

    @RequestMapping("/hanghoa/timkiem/{name}")
    public List<HangHoaDTO> timkiem(@PathVariable("name") String name){
        return hangHoaService.timkiem(name);
    }

    @PostMapping("/hanghoa/update")
    public String update(@RequestBody HangHoaDTO hangHoaDTO){
        hangHoaService.save(hangHoaDTO);
        return  "200";
    }

    @PostMapping("/hanghoa/add")
    public String add(@RequestBody HangHoaDTO hangHoaDTO){
        hangHoaService.add(hangHoaDTO);
        return  "200";
    }
}