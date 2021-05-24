package com.vnpost.e_learning.api;

import com.vnpost.e_learning.bean.BangCongTheoNgay;
import com.vnpost.e_learning.bean.BaoCaoKho;
import com.vnpost.e_learning.bean.BaoCaoLuong;
import com.vnpost.e_learning.entities.PhieuChi;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.entities.Report;
import com.vnpost.e_learning.repository.PhieuChiRepository;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import com.vnpost.e_learning.repository.ReportRepository;
import com.vnpost.e_learning.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportApi {

    @Autowired
    private BaoMatService baoMatService ;


    @Autowired
    private PhieuChiRepository phieuChiRepository ;
    @Autowired
    private PhieuThuRepository phieuThuRepository ;
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
    ///report/
    @GetMapping("/report/{code}/{name}")
    public List<Report> findAllByCode(@PathVariable("code") Integer code,
    @PathVariable("name") String name){
        return  reportRepository.findAllByCodeAndName(code,"%"+name+"%");
    }
    // /report/export

    @GetMapping("/report/export")
    public String  export (@RequestParam("thang") String thang)  throws IOException {
        baoMatService.save("Báo cáo","Xuất file báo cáo lương nhân viên theo tháng","/api/report/export");
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

    @GetMapping("/report/showDetail/baoCaoLuong")
    public List<BaoCaoLuong> showDetailBaoCaoLuong (@RequestParam("thang") String thang)  throws IOException {
        String [] mang = thang.split("-");
        List<BaoCaoLuong> baoCaoLuongs = baoCaoLuongService.baocaoluong(mang[1]);
        return baoCaoLuongs;
    }

    // /report/deleteBaoCaoLuong
    @GetMapping("/report/deleteBaoCao/{id}")
    public String deleteBaoCao (@PathVariable("id")Integer id) {
        try {
            baoMatService.save("Xóa","Xóa file báo cáo","/report/deleteBaoCao/"+id);
            reportRepository.deleteReport(id);
        }catch (Exception e){
            e.printStackTrace();
            return "500";
        }
        return "200";
    }
    @GetMapping("/report/baocaokho")
    public String  exportbaocaokho (@RequestParam("thang") String thang)  throws IOException {
        baoMatService.save("Báo cáo","Xuất file báo cáo kho theo tháng","/api/report/baocaokho");
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
        baoMatService.save("Báo cáo","Xuất file báo cáo bán hàng theo tháng","/api/report/baocaobanhang");
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


    @GetMapping("/report/showDetail/baoCaoLuongBanHang")
    public List<BaoCaoKho> baoCaoLuongBanHang (@RequestParam("thang") String thang)  throws IOException {
        String [] mang = thang.split("-");
        List<BaoCaoKho> baoCaoKhos = khoService.baocaohanghoa(mang[1]);
        return baoCaoKhos;
    }


    @GetMapping("/report/showDetail/baocaokho")
    public List<BaoCaoKho> baocaokho (@RequestParam("thang") String thang)  throws IOException {
        String [] mang = thang.split("-");
        List<BaoCaoKho> baoCaoKhos = khoService.baocaokho(mang[1]);
        return baoCaoKhos;
    }


//    @GetMapping("/report/showDetail/baocaotaichinh")
//    public List<BaoCaoKho> baocaotaichinh (@RequestParam("thang") String thang)  throws IOException {
//        String [] mang = thang.split("-");
//        List<BaoCaoKho> baoCaoKhos = khoService.baocaokho(mang[1]);
//        return baoCaoKhos;
//    }
//

    //  exportChamCong

    @PostMapping("/report/exportChamCong")
    public String  exportChamCong (@RequestBody List<BangCongTheoNgay> bangCongTheoNgays)  throws IOException {
        baoMatService.save("Xuất file","Xuất file chấm công","/api/report/exportChamCong");
        ExportBangCong excellServiceOutputExporter = new ExportBangCong();
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        String nameFile = "bangcongnhanvien"+code+".xlsx" ;
        String path = "D://postman-delivery//report//baocaocoha//"+nameFile ;
        excellServiceOutputExporter.createOutputFile(path,bangCongTheoNgays);

        return nameFile ;

    }



    // bao cao doanh thu
    @GetMapping("/report/baocaodoanhthu")
    public String  baocaodoanhthu (@RequestParam("thang") String thang)  throws IOException {
        baoMatService.save("Báo cáo","Xuất file báo cáo doanh thu theo tháng","/api/report/baocaodoanhthu");
        String [] mang = thang.split("-");
        // khởi tạo
        ExportBaoCaoDoanhThu exportBaoCaoDoanhThu = new ExportBaoCaoDoanhThu();
        ExportBaoCaoPhieuThu exportBaoCaoPhieuThu = new ExportBaoCaoPhieuThu();
        ExportBaoCaoPhieuChi exportBaoCaoPhieuChi = new ExportBaoCaoPhieuChi();
        ExportBangCong exportBangCong = new ExportBangCong();
        ExcellServiceOutputExporter excellServiceOutputExporter = new ExcellServiceOutputExporter();

        // tạo sheeet
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        workbook.createSheet("Báo cáo tồn kho");
        workbook.createSheet("Chi tiết phiếu thu");
        workbook.createSheet("Chi tiết phiếu chi");
        workbook.createSheet("Lương nhân viên");


        // xử lí
        int code = (int) Math.floor(((Math.random() * 899999) + 100000));
        String nameFile = "baocaodoanhthu"+code+".xlsx" ;
        String path = "D://postman-delivery//report//baocaocoha//"+nameFile ;


        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(new Date());
        //String ten , String nguoitao , String ngaytao , Integer code

        // lấy ra dữ lieu
        List<BaoCaoKho> baoCaoKhos = khoService.baocaohanghoa(mang[1]);
        List<PhieuChi> phieuChis = phieuChiRepository.layphieuchitheothang(mang[1]);
        List<PhieuThu> phieuThus = phieuThuRepository.layphieuthutheothang(mang[1]);
        List<BaoCaoLuong> baoCaoLuongs = baoCaoLuongService.baocaoluong(mang[1]);

        // ghi vào file excell
        exportBaoCaoDoanhThu.createOutputFile(path,baoCaoKhos,workbook);
        exportBaoCaoPhieuChi.createOutputFile(path,phieuChis,workbook);
        exportBaoCaoPhieuThu.createOutputFile(path,phieuThus,workbook);
        excellServiceOutputExporter.createFileForBaoCaoTong(baoCaoLuongs,workbook);
        // lưu vào ổ

        File file = new File(StringUtils.substringBeforeLast(path, "/"));
        System.out.println(StringUtils.substringBeforeLast(path, "/"));
        if (!file.exists()) {
            file.mkdirs();
        }

        try (OutputStream os = new FileOutputStream(path)) {
            workbook.write(os);
            workbook.close();

        }


        // save file báo cáo
        reportRepository.saveReport(nameFile,"admin",dateString,2);

        return nameFile ;


    }


}
