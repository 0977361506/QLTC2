package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.DanhMucHangHoaDTO;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.repository.KhoRepository;
import com.vnpost.e_learning.service.BaoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class KhoApi{


    @Autowired
    private KhoRepository khoRepository ;
    @Autowired
    private BaoMatService baoMatService ;

    @GetMapping("/categoryKho")
    public List<Kho> finAll(){
        return khoRepository.findAll() ;
    }


    @RequestMapping("/categoryKho/{id}")
    public Kho getList(@PathVariable("id") Integer id){
        return khoRepository.findById(id).get();
    }

    @RequestMapping("/categoryKho/timkiem/{name}")
    public List<Kho> timkiem(@PathVariable("name") String name){
        baoMatService.save("Tìm kiếm","Tìm kiếm  kho","/categoryKho/timkiem/"+name);
        return khoRepository.timkiem("%"+name+"%");
    }

    @PostMapping("/categoryKho/update")
    public String update(@RequestBody Kho danhMucHangHoa){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        String dateString=sdf.format(date);
        baoMatService.save("Cập nhật","Cập nhật thông tin kho","/categoryKho/update");
        khoRepository.savedanhmuc(danhMucHangHoa.getTenKho(),
                dateString , danhMucHangHoa.getDanh_muc_khoid()
                ,danhMucHangHoa.getId());
        return  "200";
    }

    @PostMapping("/categoryKho/add")
    public String add(@RequestBody Kho danhMucHangHoa){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        String dateString=sdf.format(date);
        baoMatService.save("Thêm mới","Thêm mới thông tin kho","/categoryKho/add");
        khoRepository.add(danhMucHangHoa.getTenKho(),dateString,danhMucHangHoa.getDanh_muc_khoid());
        return  "200";
    }
}
