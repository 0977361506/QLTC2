package com.vnpost.e_learning.api;

import com.vnpost.e_learning.bean.CartBean;
import com.vnpost.e_learning.bean.PhieuBean;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.entities.PhieuNhap;
import com.vnpost.e_learning.entities.PhieuXuat;
import com.vnpost.e_learning.repository.PhieuNhapRepository;
import com.vnpost.e_learning.repository.PhieuXuatRepository;
import com.vnpost.e_learning.service.BaoMatService;
import com.vnpost.e_learning.service.PhieuNhapService;
import com.vnpost.e_learning.service.PhieuXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhieuXuatApi {
    @Autowired
    private PhieuXuatService phieuXuatService ;

    @Autowired
    private PhieuXuatRepository phieuXuatRepository ;

    @Autowired
    private BaoMatService baoMatService ;

    @Autowired
    private CartBean cartBean ;

    @RequestMapping("/getAllPhieuXuat")
    public List<PhieuBean> getAllPhieuNhap (){
        return  phieuXuatService.getALLPhieuNhap();
    }

    @RequestMapping("/getDetailPhieuXuat/{id}")
    public Object[] getDetailPhieuNhap (@PathVariable("id") Integer id){
        return  phieuXuatService.getInfoDetail(id);
    }

    //taophieunhap

    @RequestMapping("/taophieuxuat")
    public String taophieunhap (@RequestBody PhieuXuat phieuXuat){
        baoMatService.save("Thêm mới","Tạo phiếu xuất","/api/taophieuxuat");
        phieuXuatService.save(phieuXuat);
        List<PhieuXuat> phieuXuats = phieuXuatRepository.findAll();
        PhieuXuat phieuNhapnew = phieuXuats.get(phieuXuats.size()-1);
        phieuXuatService.saveALL(cartBean.getList(),phieuNhapnew.getId());
        return phieuNhapnew.getId().toString() ;
    }


    @RequestMapping("/timkiemPhieuxuat/{name}")
    public List<PhieuBean> timkiemPhieunhap (@PathVariable("name") String name){
        baoMatService.save("Tìm kiếm","Tìm kiếm phiếu xuất","/api/timkiemPhieuxuat/"+name);
        return  phieuXuatService.timkiem("%"+name+"%");
    }

    //updateStatus

    @RequestMapping("/updateStatusXuat/{id}/{status}")
    public String updateStatus (@PathVariable("id") Integer id ,@PathVariable("status") Integer status){
        baoMatService.save("Cập nhật","Cập nhật trang thái phiếu xuất","/api/updateStatusXuat/"+id+"/"+status);
        if(status==1)  phieuXuatRepository.updateStatus(0,id);
        else  phieuXuatRepository.updateStatus(1,id);
        return  "200" ;
    }

}
