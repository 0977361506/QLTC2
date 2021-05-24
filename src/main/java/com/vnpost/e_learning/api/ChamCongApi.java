package com.vnpost.e_learning.api;

import com.vnpost.e_learning.bean.BangCongTheoNgay;
import com.vnpost.e_learning.bean.BaoCaoLuong;
import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.NguoiDung;
import com.vnpost.e_learning.repository.ChamCongRepository;
import com.vnpost.e_learning.repository.NguoiDungRepository;
import com.vnpost.e_learning.service.BaoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChamCongApi {
    @Autowired
    private ChamCongRepository chamCongRepository ;
    @Autowired private NguoiDungRepository nguoiDungRepository ;

    @Autowired
    private BaoMatService baoMatService ;

    @PostMapping("/checkChamcong")
    public NguoiDung checkChamcong(@RequestBody BaoCaoLuong caoLuong){
        NguoiDung nguoiDung = nguoiDungRepository.findById(Integer.parseInt(caoLuong.getMand())).get() ;
        if(chamCongRepository.existsByNguoiDungIDAndNgaychamcong(nguoiDung,
                caoLuong.getThanglamviec()))  return  null ;
        return  nguoiDung;
    }

    @PostMapping("/saveChamCong")
    public String saveChamCong(@RequestBody List<BangCongTheoNgay> bangCongTheoNgays){
        try {
            for(BangCongTheoNgay bangCongTheoNgay : bangCongTheoNgays){
                String thang = bangCongTheoNgay.getNgaylamviec().split("-")[1];
                chamCongRepository.saveChamCong("Chấm công",bangCongTheoNgay.getSongaylamviec(),
                        bangCongTheoNgay.getId(),thang,bangCongTheoNgay.getNgaylamviec());

            }

            baoMatService.save("Lưu","Thêm mới bảng công","/api/saveChamCong");

        }catch (Exception e){
            e.printStackTrace();
            return "500";
        }
        return "200";
    }

}
