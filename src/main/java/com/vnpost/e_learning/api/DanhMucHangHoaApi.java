package com.vnpost.e_learning.api;

import com.vnpost.e_learning.dto.DanhMucHangHoaDTO;
import com.vnpost.e_learning.dto.HangHoaDTO;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.repository.DanhmucHangHoaRepository;
import com.vnpost.e_learning.service.DanhMucHangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DanhMucHangHoaApi {
    @Autowired
    private DanhMucHangHoaService service ;
    @Autowired
    private DanhmucHangHoaRepository danhmucHangHoaRepository ;
    @GetMapping("/category")
    public List<DanhMucHangHoaDTO> getAll(){
        return  service.findAll();
    }

    @RequestMapping("/category/{id}")
    public DanhMucHangHoaDTO getList(@PathVariable("id") Integer id){
        return service.findByID(id);
    }

    @RequestMapping("/category/timkiem/{name}")
    public List<DanhMucHangHoa> timkiem(@PathVariable("name") String name){
        return danhmucHangHoaRepository.timkiem("%"+name+"%");
    }

    @PostMapping("/category/update")
    public String update(@RequestBody DanhMucHangHoa danhMucHangHoa){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        String dateString=sdf.format(date);
        danhmucHangHoaRepository.savedanhmuc(danhMucHangHoa.getTenDM(),danhMucHangHoa.getKhoid(),
                 dateString
                ,danhMucHangHoa.getId());
        return  "200";
    }

    @PostMapping("/category/add")
    public String add(@RequestBody DanhMucHangHoa danhMucHangHoa){
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        String dateString=sdf.format(date);
        danhmucHangHoaRepository.add(danhMucHangHoa.getTenDM(),danhMucHangHoa.getKhoid(),dateString);
        return  "200";
    }

}
