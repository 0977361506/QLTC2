package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.DanhMucHangHoaDTO;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.repository.GiaRepository;
import com.vnpost.e_learning.service.BaoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GiaApi {
    @Autowired
    private GiaRepository service ;
    @Autowired
    private BaoMatService baoMatService ;

    @GetMapping("/gia")
    public List<Gia> getAll(){
        return  service.findAll();
    }

    @RequestMapping("/gia/{id}")
    public Gia getList(@PathVariable("id") Integer id){
        return service.findById(id).get();
    }

    @RequestMapping("/gia/timkiem/{name}")
    public List<Gia> timkiem(@PathVariable("name") String name){
        baoMatService.save("Tìm kiếm","Tìm kiếm giá hàng hóa","/giá/timkiem/"+name);
        return service.timkiem("%"+name+"%");
    }

    @PostMapping("/gia/update")
    public String update(@RequestBody Gia gia){
         //   UPDATE gia SET ten_gia=?1, gia =?2 , ghichu = ?3 ,hang_hoaid=?4 where id=?5"
        System.out.println(gia.getGhichu());
        baoMatService.save("Cập nhật","Cập nhật giá hàng hóa","/gia/update");
        service.savedanhmuc(gia.getTenGia(),gia.getGia(),gia.getGhichu(),gia.getHang_hoaid(),gia.getId());
        return  "200";
    }

    @PostMapping("/gia/add")  // "INSERT INTO gia (ten_gia,gia,ghichu,hang_hoaid) VALUES (?1,?2,?3,?4)
    public String add(@RequestBody Gia gia){
        baoMatService.save("Thêm mới","Thêm mới giá hàng hóa","/gia/add");
        service.add(gia.getTenGia() , gia.getGia(),gia.getGhichu(),gia.getHang_hoaid());
        return  "200";
    }

}
