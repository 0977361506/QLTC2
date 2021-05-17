package com.vnpost.e_learning.api;

import com.vnpost.e_learning.bean.CartBean;
import com.vnpost.e_learning.bean.PhieuBean;
import com.vnpost.e_learning.bean.PhieuChiTietBean;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.entities.PhieuNhap;
import com.vnpost.e_learning.repository.PhieuNhapRepository;
import com.vnpost.e_learning.service.PhieuNhapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhieuNhapApi {

    @Autowired
    private PhieuNhapService phieuNhapService ;

    @Autowired
    private PhieuNhapRepository phieuNhapRepository ;

    @Autowired
    private CartBean cartBean ;

    @RequestMapping("/getAllPhieuNhap")
    public List<PhieuBean> getAllPhieuNhap (){
        return  phieuNhapService.getALLPhieuNhap();
    }

    @RequestMapping("/getDetailPhieuNhap/{id}")
    public Object[] getDetailPhieuNhap (@PathVariable("id") Integer id){
        return  phieuNhapService.getInfoDetail(id);
    }

    @RequestMapping("/addtophieu/{id}")
    public Collection<HangHoa> addtocart (@PathVariable("id") Integer id){
        cartBean.addToCart(id) ;
        return  cartBean.getList();
    }

    @RequestMapping("/updateQuantity/{id}/{soluong}")
    public Collection<HangHoa> updateQuantity (@PathVariable("id") Integer id
    ,@PathVariable("soluong") Integer soluong){
        cartBean.updateQuantity(id,soluong) ;
        return  cartBean.getList();
    }

    //deleteToPhieu

    @RequestMapping("/deleteToPhieu/{id}")
    public Collection<HangHoa> updateQuantity (@PathVariable("id") Integer id  ){
        cartBean.remove(id); ;
        return  cartBean.getList();
    }

    //taophieunhap

    @RequestMapping("/taophieunhap")
    public String taophieunhap (@RequestBody PhieuNhap phieuNhap){
       phieuNhapService.save(phieuNhap);
       List<PhieuNhap> phieuNhaps = phieuNhapRepository.findAll();
       PhieuNhap phieuNhapnew = phieuNhaps.get(phieuNhaps.size()-1);
       phieuNhapService.saveALL(cartBean.getList(),phieuNhapnew.getId());
       return phieuNhapnew.getId().toString() ;
    }


    @RequestMapping("/timkiemPhieunhap/{name}")
    public List<PhieuBean> timkiemPhieunhap (@PathVariable("name") String name){
        return  phieuNhapService.timkiem("%"+name+"%");
    }

    //updateStatus

    @RequestMapping("/updateStatus/{id}/{status}")
    public String updateStatus (@PathVariable("id") Integer id ,@PathVariable("status") Integer status){
        if(status==1)  phieuNhapRepository.updateStatus(0,id);
        else  phieuNhapRepository.updateStatus(1,id);
        return  "200" ;
    }

}
