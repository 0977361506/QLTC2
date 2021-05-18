package com.vnpost.e_learning.api;

import com.vnpost.e_learning.bean.BaoCaoKho;
import com.vnpost.e_learning.bean.BaoCaoLuong;
import com.vnpost.e_learning.entities.Report;
import com.vnpost.e_learning.repository.ReportRepository;
import com.vnpost.e_learning.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportApi {
    @Autowired
    ReportRepository reportRepository ;
    @Autowired
    private BaoCaoLuongService baoCaoLuongService ;
    @Autowired
    private KhoService khoService ;
    @GetMapping("/report/{code}")
    public List<Report> findAllByCode(@PathVariable("code") Integer code){
        return  reportRepository.findAllByCode(code);
    }

    // /report/export

    @GetMapping("/report/export")
    public String  export (@RequestParam("thang") String thang)  throws IOException {
        String [] mang = thang.split("-");
        ExcellServiceOutputExporter excellServiceOutputExporter = new ExcellServiceOutputExporter();
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        String nameFile = "baocaoQLTCv"+code+".xlsx" ;
        String path = "D://postman-delivery//report//baocaocoha//"+nameFile ;
        List<BaoCaoLuong> baoCaoLuongs = baoCaoLuongService.baocaoluong(mang[1]);

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(new Date());

        //String ten , String nguoitao , String ngaytao , Integer code
        if(baoCaoLuongs.size()>0){
            reportRepository.saveReport(nameFile,"admin",dateString,1);
            excellServiceOutputExporter.createOutputFile(path,baoCaoLuongs);
            return nameFile ;
        }
        return "500";
    }


    @GetMapping("/report/baocaokho")
    public String  exportbaocaokho (@RequestParam("thang") String thang)  throws IOException {
        String [] mang = thang.split("-");
        ExportBaoCaoKho excellServiceOutputExporter = new ExportBaoCaoKho();
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        String nameFile = "baocaokho"+code+".xlsx" ;
        String path = "D://postman-delivery//report//baocaocoha//"+nameFile ;
        List<BaoCaoKho> baoCaoKhos = khoService.baocaokho(mang[1]);

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(new Date());

        //String ten , String nguoitao , String ngaytao , Integer code
        if(baoCaoKhos.size()>0){

            excellServiceOutputExporter.createOutputFile(path,baoCaoKhos);
            reportRepository.saveReport(nameFile,"admin",dateString,4);
            return nameFile ;
        }
        return "500";
    }

    // baocaobanhang
    @GetMapping("/report/baocaobanhang")
    public String  baocaobanhang (@RequestParam("thang") String thang)  throws IOException {
        String [] mang = thang.split("-");
        ExportBaoCaoBanHang excellServiceOutputExporter = new ExportBaoCaoBanHang();
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        String nameFile = "baocaobanhang"+code+".xlsx" ;
        String path = "D://postman-delivery//report//baocaocoha//"+nameFile ;
        List<BaoCaoKho> baoCaoKhos = khoService.baocaohanghoa(mang[1]);

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(new Date());

        //String ten , String nguoitao , String ngaytao , Integer code
        if(baoCaoKhos.size()>0){

            excellServiceOutputExporter.createOutputFile(path,baoCaoKhos);
            reportRepository.saveReport(nameFile,"admin",dateString,3);
            return nameFile ;
        }
        return "500";
    }
}
