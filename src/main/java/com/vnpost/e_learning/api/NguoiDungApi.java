package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.NguoiDung;
import com.vnpost.e_learning.repository.NguoiDungRepository;
import com.vnpost.e_learning.service.BaoMatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NguoiDungApi {
    @Autowired
    private BaoMatService baoMatService ;

    @Autowired
    private NguoiDungRepository nguoiDungRepository ;

    @Autowired
    HttpSession session ;

    @GetMapping("/nguoidung")
    public List<NguoiDung> finAll(){
      return nguoiDungRepository.findAll();
    }

    //  filterNguoidung

    @GetMapping("/filterNguoidung/{role}")
    public List<NguoiDung> filterNguoidung(@PathVariable("role") Integer role){
        if(role==0)   return nguoiDungRepository.findAll();
        return nguoiDungRepository.findAllByViTri(role);
    }

    // searchNguoiDung

    @GetMapping("/searchNguoiDung/{name}")
    public List<NguoiDung> searchNguoiDung(@PathVariable("name") String name){
        baoMatService.save("Tìm kiếm","Tìm kiếm thông tin người dùng","/api/searchNguoiDung/"+name);
        return nguoiDungRepository.findAllByName("%"+name+"%");
    }

    // updateTrangthai

    @GetMapping("/updateTrangthai/{id}/{status}")
    public String updateTrangthai(@PathVariable("id") Integer id,@PathVariable("status") Integer status){
        baoMatService.save("Cập nhật","Cập nhật trạng thái người dùng","/api/updateTrangthai/"+id+"/"+status);
        if(status==1) nguoiDungRepository.updateTrangthai(0,id);
        else nguoiDungRepository.updateTrangthai(1,id);
        return "200";
    }

    // nguoidung
    @GetMapping("/nguoidung/{id}")
    public NguoiDung findById(@PathVariable("id") Integer id){
        return nguoiDungRepository.findById(id).get();
    }

    // /nguoidung/capnhat

    @PostMapping("/nguoidung/capnhat")
    public String capnhat(@RequestBody NguoiDung nguoiDung){
        //  String chucdanh , String email , String fullname , String image , String mand , String phone,
        //            Integer role , Integer trangthai , Integer id
        baoMatService.save("Cập nhật","Cập nhật thông tin người dùng","/api/nguoidung/capnhat");
        nguoiDungRepository.update(nguoiDung.getChucdanh(),nguoiDung.getEmail(),nguoiDung.getFullName(),nguoiDung.getImage(),nguoiDung.getMaND()
        ,nguoiDung.getPhone(),nguoiDung.getRole(),nguoiDung.getTrangthai(),nguoiDung.getId());
        return "200";
    }


    @PostMapping("/nguoidung/themmoi")
    public String themmoi(@RequestBody NguoiDung nguoiDung){
        //  String chucdanh , String email , String fullname , String image , String mand , String phone,
        //            Integer role , Integer trangthai , Integer id
        baoMatService.save("Thêm mới","Thêm mới thông tin người dùng","/api/nguoidung/themmoi");
        nguoiDungRepository.add(nguoiDung.getChucdanh(),nguoiDung.getEmail(),nguoiDung.getFullName(),nguoiDung.getImage(),nguoiDung.getMaND()
                ,nguoiDung.getPhone(),nguoiDung.getRole(),nguoiDung.getTrangthai());
        return "200";
    }

    @GetMapping("/nguoidung/login")
    public NguoiDung checkLogin(@RequestParam(name = "username") String username ,
                                @RequestParam(name = "password") String password){

        NguoiDung user= nguoiDungRepository.findByUsernameAndPassword(username,password);

        if(user!=null && user.getRole()==1) {
            session.setAttribute("user", user);
            baoMatService.save("Đăng nhập","Đăng nhập hệ thống","/api/admin/login");
            return  user;
        }
        return  null;
    }

}
