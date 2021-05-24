package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.entities.BaoMat;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.entities.NguoiDung;
import com.vnpost.e_learning.repository.BaoMatRepository;
import com.vnpost.e_learning.service.HangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HangHoaApi {
    @Autowired
    private HangHoaService hangHoaService ;
    @Autowired
    BaoMatRepository baoMatRepository ;

    @Autowired
    HttpSession session ;

    @RequestMapping("/hanghoa/{id}")
    public HangHoaDTO getList(@PathVariable("id") Integer id){
        return hangHoaService.findByID(id);
    }

    @RequestMapping("/hanghoa/timkiem/{name}")
    public List<HangHoaDTO> timkiem(@PathVariable("name") String name){
        BaoMat baoMat = new BaoMat();
        baoMat.setAction("Tìm kiếm");
        NguoiDung user = (NguoiDung) session.getAttribute("user");
        baoMat.setMaND(user.getId());
        baoMat.setNote("Thực hiện chức năng tìm kiếm hàng hóa");
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(date);
        baoMat.setTime(dateString);
        baoMat.setUrl("/hanghoa/timkiem/"+name);
        baoMatRepository.save(baoMat);
        return hangHoaService.timkiem(name);
    }

    @PostMapping("/hanghoa/update")
    public String update(@RequestBody HangHoaDTO hangHoaDTO){
        BaoMat baoMat = new BaoMat();
        baoMat.setAction("Cập nhật");
        NguoiDung user = (NguoiDung) session.getAttribute("user");
        baoMat.setMaND(user.getId());
        baoMat.setNote("Thực hiện chức năng cập nhật hàng hóa");
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(date);
        baoMat.setTime(dateString);
        baoMat.setUrl("/hanghoa/update");
        baoMatRepository.save(baoMat);
        hangHoaService.save(hangHoaDTO);
        return  "200";
    }

    @PostMapping("/hanghoa/add")
    public String add(@RequestBody HangHoaDTO hangHoaDTO){
        BaoMat baoMat = new BaoMat();
        baoMat.setAction("Thêm mới");
        NguoiDung user = (NguoiDung) session.getAttribute("user");
        baoMat.setMaND(user.getId());
        baoMat.setNote("Thực hiện chức năng thêm mới hàng hóa");
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(date);
        baoMat.setTime(dateString);
        baoMat.setUrl("/hanghoa/add");
        baoMatRepository.save(baoMat);
        hangHoaService.add(hangHoaDTO);
        return  "200";
    }
}