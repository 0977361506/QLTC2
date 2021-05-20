package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhieuThuApi {
    @Autowired
    private PhieuThuRepository phieuThuRepository ;
    @GetMapping("/phieuthu")
    public List<PhieuThu> phieuThus(){
        return  phieuThuRepository.findAll() ;
    }


    @RequestMapping("/phieuthu/{id}")
    public PhieuThu getPhieuthuDetail(@PathVariable("id") Integer id){
        return phieuThuRepository.findById(id).get();
    }

    @RequestMapping("/phieuthu/timkiem/{name}")
    public List<PhieuThu> timkiem(@PathVariable("name") String name){
        return phieuThuRepository.timkiem("%"+name+"%");
    }



    @PostMapping("/phieuthu/add")
    public String add(@RequestBody PhieuThu phieuThu){
       //String diachi ,String doituong , String ghichu ,
        //                     String maphieu , String ngaytao,
        //                     String noidungthu , String sotk ,Float sotien , String tennguoinop ,
        //                     Integer idnguoidung);
        phieuThuRepository.add(
                phieuThu.getDiachiThu(),
                phieuThu.getDoituong(),
                phieuThu.getGhichu(),phieuThu.getMaPhieuThu(),phieuThu.getNgaytao(),
                phieuThu.getNoiidungThu(),phieuThu.getSoTK(),phieuThu.getSotien(),
                phieuThu.getTennguoinop(),phieuThu.getMaND()
        );
        return  "200";
    }


}
