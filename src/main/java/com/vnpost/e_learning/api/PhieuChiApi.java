package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.PhieuChi;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.repository.PhieuChiRepository;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import com.vnpost.e_learning.service.BaoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")

public class PhieuChiApi {
    @Autowired
    private BaoMatService baoMatService ;

    @Autowired
    private PhieuChiRepository phieuChiRepository ;
    @GetMapping("/phieuchi")
    public List<PhieuChi> phieuThus(){
        return  phieuChiRepository.findAll() ;
    }


    @RequestMapping("/phieuchi/{id}")
    public PhieuChi getPhieuthuDetail(@PathVariable("id") Integer id){
        baoMatService.save("Xem chi tiết","Xem chi tiết phiếu chi","/api/phieuchi/"+id);
        return phieuChiRepository.findById(id).get();
    }

    @RequestMapping("/phieuchi/timkiem/{name}")
    public List<PhieuChi> timkiem(@PathVariable("name") String name){
        baoMatService.save("Tìm kiếm","Tìm kiếm thông tin phiếu chi","/api/phieuchi/timkiem/"+name);
        return phieuChiRepository.timkiem("%"+name+"%");
    }



    @PostMapping("/phieuchi/add")
    public String add(@RequestBody PhieuChi phieuThu){
        baoMatService.save("Thêm mới","Tạo phiếu chi","/api/phieuchi/add");
        phieuChiRepository.add(
                phieuThu.getDoituongthanhtoan(),
                phieuThu.getGhichu(),phieuThu.getMaPhieuChi(),phieuThu.getNgaytao(),
                phieuThu.getNoidungchi(),phieuThu.getSoTK(),phieuThu.getSotien(),
                phieuThu.getTenNguoiNhan(),phieuThu.getMaND()
        );
        return  "200";
    }
}
