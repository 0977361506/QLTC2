package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.DanhMucKho;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.repository.DanhMucKhoRepository;
import com.vnpost.e_learning.repository.KhoRepository;
import com.vnpost.e_learning.service.BaoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DanhMucKhoAPi {
    @Autowired
    private DanhMucKhoRepository danhMucKhoRepository ;
    @Autowired
    private BaoMatService baoMatService ;

    @GetMapping("/danhmuckho")
    public List<DanhMucKho> finAll(){
        return danhMucKhoRepository.findAll() ;
    }


    @RequestMapping("/danhmuckho/{id}")
    public DanhMucKho getList(@PathVariable("id") Integer id){
        return danhMucKhoRepository.findById(id).get();
    }

    @RequestMapping("/danhmuckho/timkiem/{name}")
    public List<DanhMucKho> timkiem(@PathVariable("name") String name){
        baoMatService.save("Tìm kiếm","Tìm kiếm danh mục kho","/danhmuckho/timkiem/"+name);
        return danhMucKhoRepository.timkiem("%"+name+"%");
    }

    @PostMapping("/danhmuckho/update")
    public String update(@RequestBody DanhMucKho danhMucHangHoa){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        String dateString=sdf.format(date);
        baoMatService.save("Cập nhật","Cập nhật danh mục kho","/danhmuckho/update");
        danhMucKhoRepository.savedanhmuc(danhMucHangHoa.getTenDM(),
                dateString , danhMucHangHoa.getId());
        return  "200";
    }

    @PostMapping("/danhmuckho/add")
    public String add(@RequestBody DanhMucKho danhMucHangHoa){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        String dateString=sdf.format(date);
        baoMatService.save("Thêm mới","Thêm mới danh mục kho","/danhmuckho/add");
        danhMucKhoRepository.add(danhMucHangHoa.getTenDM(),dateString);
        return  "200";
    }
}
