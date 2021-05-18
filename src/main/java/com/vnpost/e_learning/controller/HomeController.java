package com.vnpost.e_learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @GetMapping("/index")
    public String index (){
        return "admin/index";
    }
    @GetMapping("/login")
    public String login (){
        return "login";
    }
    @GetMapping("/hanghoa/quanlyhanghoa")
    public String quanlyhanghoa (){
        return "admin/hanghoa/danhsachhanghoa";
    }

    @GetMapping("/hanghoa/danhmuchanghoa")
    public String quanlydanhmuchanghoa (){
        return "admin/hanghoa/danhmuchanghoa";
    }

    @GetMapping("/hanghoa/giaban")
    public String giaban (){
        return "admin/hanghoa/quanlygiaban";
    }

    @GetMapping("/kho/quanlykho")
    public String quanlykho (){
        return "admin/kho/quanlythongtinkho";
    }

    @GetMapping("/kho/danhmuckho")
    public String danhmuckho (){
        return "admin/kho/danhmuckho";
    }

    @GetMapping("/kho/phieunhap")
    public String phieuNhap (){
        return "admin/kho/quanlyPhieuNhap";
    }


    @GetMapping("/kho/phieuxuat")
    public String phieuXuat (){
        return "admin/kho/quanlyPhieuXuat";
    }

    @GetMapping("/luong/chiphi")
    public String chiphi (){
        return "admin/luong/quanlichiphi";
    }


    @GetMapping("/luong/nguoidung")
    public String nguoidung (){
        return "admin/luong/quanlynguoidung";
    }


    @GetMapping("/luong/tinhluongnhanvien")
    public String tinhluongnhanvien (){
        return "admin/luong/tinhluongnhanvien";
    }

    @GetMapping("/thuchi/phieuchi")
    public String phieuchi (){
        return "admin/thuchi/quanlyphieuchi";
    }

    @GetMapping("/thucthi/phieuthu")
    public String phieuThu (){
        return "admin/thuchi/quanlyphieuthu";
    }

    @GetMapping("/baocao/baocaobanhang")
    public String baocaobanhang (){
        return "admin/baocao/baocaobanhang";
    }

    @GetMapping("/baocao/baocaokho")
    public String baocaokho (){
        return "admin/baocao/baocaokho";
    }

    @GetMapping("/baocao/baocaotaichinh")
    public String baocaotaichinh (){
        return "admin/baocao/baocaotaichinh";
    }










}
