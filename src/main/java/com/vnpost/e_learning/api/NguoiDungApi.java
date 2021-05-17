package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.NguoiDung;
import com.vnpost.e_learning.repository.NguoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NguoiDungApi {
    @Autowired
    private NguoiDungRepository nguoiDungRepository ;


    @GetMapping("/nguoidung")
    public List<NguoiDung> finAll(){
      return nguoiDungRepository.findAll();
    }

    //  filterNguoidung

    @GetMapping("/filterNguoidung/{role}")
    public List<NguoiDung> filterNguoidung(@PathVariable("role") Integer role){
        if(role==0)   return nguoiDungRepository.findAll();
        return nguoiDungRepository.findAllByViTri(role);
    }

    // searchNguoiDung

    @GetMapping("/searchNguoiDung/{name}")
    public List<NguoiDung> searchNguoiDung(@PathVariable("name") String name){
        return nguoiDungRepository.findAllByName("%"+name+"%");
    }

    // updateTrangthai

    @GetMapping("/updateTrangthai/{id}/{status}")
    public String updateTrangthai(@PathVariable("id") Integer id,@PathVariable("status") Integer status){
        if(status==1) nguoiDungRepository.updateTrangthai(0,id);
        else nguoiDungRepository.updateTrangthai(1,id);
        return "200";
    }

    // nguoidung
    @GetMapping("/nguoidung/{id}")
    public NguoiDung findById(@PathVariable("id") Integer id){
        return nguoiDungRepository.findById(id).get();
    }

    // /nguoidung/capnhat

    @PostMapping("/nguoidung/capnhat")
    public String capnhat(@RequestBody NguoiDung nguoiDung){
        //  String chucdanh , String email , String fullname , String image , String mand , String phone,
        //            Integer role , Integer trangthai , Integer id
        nguoiDungRepository.update(nguoiDung.getChucdanh(),nguoiDung.getEmail(),nguoiDung.getFullName(),nguoiDung.getImage(),nguoiDung.getMaND()
        ,nguoiDung.getPhone(),nguoiDung.getRole(),nguoiDung.getTrangthai(),nguoiDung.getId());
        return "200";
    }


    @PostMapping("/nguoidung/themmoi")
    public String themmoi(@RequestBody NguoiDung nguoiDung){
        //  String chucdanh , String email , String fullname , String image , String mand , String phone,
        //            Integer role , Integer trangthai , Integer id
        nguoiDungRepository.add(nguoiDung.getChucdanh(),nguoiDung.getEmail(),nguoiDung.getFullName(),nguoiDung.getImage(),nguoiDung.getMaND()
                ,nguoiDung.getPhone(),nguoiDung.getRole(),nguoiDung.getTrangthai());
        return "200";
    }

}
