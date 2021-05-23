package com.vnpost.e_learning.service;

import com.vnpost.e_learning.bean.BaoCaoKho;
import com.vnpost.e_learning.bean.BaoCaoLuong;
import com.vnpost.e_learning.entities.PhieuChi;
import com.vnpost.e_learning.entities.PhieuThu;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
@Getter
@Setter
public class ExportBaoCaoDoanhThu {
    private SXSSFWorkbook workbook;
    private SXSSFSheet sheet;

    public ExportBaoCaoDoanhThu() {
        workbook = new SXSSFWorkbook(10000000);
    }



    public void writeContent(List<BaoCaoKho> baoCaoKhos, List<PhieuThu> phieuThus , List<PhieuChi> phieuChis){


        int tieude = 1;
        sheet = workbook.createSheet("báo cáo kho");
        SXSSFRow rowtieude = sheet.createRow(tieude);


        makeCell(rowtieude,"STT",0,1);
        makeCell(rowtieude,"Mã hàng hóa",1,1);
        makeCell(rowtieude,"Mã code",2,1);
        makeCell(rowtieude,"Tên hàng hóa",3,1);
        makeCell(rowtieude,"Số lượng nhập",4,1);
        makeCell(rowtieude,"Số lượng xuất",5,1);
        makeCell(rowtieude,"Số lượng bán ra",6,1);
        makeCell(rowtieude,"Số lượng còn lại",7,1);


        int rownum = 2 ;
        int stt = 0 ;
        for (BaoCaoKho baoCaoKho : baoCaoKhos) {
            rownum++;
            SXSSFRow rowtValue = sheet.createRow(rownum);
            String soluongnhap = (baoCaoKho.getSoluongnhap()!=null)?baoCaoKho.getSoluongnhap().toString() : "0" ;
            String soluongxuat = (baoCaoKho.getSoluongxuat()!=null)?baoCaoKho.getSoluongxuat().toString() : "0" ;
            String soluongbanra = (baoCaoKho.getSoluongbanra()!=null)?baoCaoKho.getSoluongbanra().toString() : "0" ;
            String soluongconlai = (baoCaoKho.getSoluongconlai()!=null)? baoCaoKho.getSoluongconlai().toString(): "0";
            makeCell(rowtValue,String.valueOf(stt++),0,0);
            makeCell(rowtValue,baoCaoKho.getMaHH().toString(),1,0);
            makeCell(rowtValue,baoCaoKho.getMaCode(),2,0);
            makeCell(rowtValue,baoCaoKho.getTenHH(),3,0);
            makeCell(rowtValue,soluongnhap,4,0);
            makeCell(rowtValue,soluongxuat,5,0);
            makeCell(rowtValue,soluongbanra,6,0);
            makeCell(rowtValue,soluongconlai,7,0);
        }

        int sttrowthuchi = 9+baoCaoKhos.size();  // khoản thu

        CellStyle cellStyle= workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        cellStyle.setFont(font);


        SXSSFRow hangkhoanthu = sheet.createRow(sttrowthuchi+2);  // danh sach khaorn thu

        makeCell(hangkhoanthu,"STT",0,1);
        makeCell(hangkhoanthu,"Tên khoản thu",1,1);
        makeCell(hangkhoanthu,"Số tiền",2,1);
        makeCell(hangkhoanthu,"Ghi chú",3,1);

        int sttdsthu = 0 ;
        int startrowphieuthu = sttrowthuchi+4 ;
        for(PhieuThu phieuThu : phieuThus){
            startrowphieuthu++;
            SXSSFRow rowtValue = sheet.createRow(startrowphieuthu);
            makeCell(rowtValue,String.valueOf(sttdsthu++),0,0);
            makeCell(rowtValue,phieuThu.getNoiidungThu(),1,0);
            makeCell(rowtValue,String.valueOf(phieuThu.getSotien()),2,0);
            makeCell(rowtValue,phieuThu.getGhichu(),3,0);

        }

        // hiện thị khoản chi


        int tieudephieuchi = 3+baoCaoKhos.size()+phieuThus.size();  // khoản thu

//        sheet.addMergedRegion(new CellRangeAddress(tieudephieuchi,tieudephieuchi,0,5));

        SXSSFRow hangkhoanchi = sheet.createRow(tieudephieuchi+2);  // danh sach khaorn thu

        makeCell(hangkhoanchi,"STT",0,1);
        makeCell(hangkhoanchi,"Tên khoản chi",1,1);
        makeCell(hangkhoanchi,"Số tiền",2,1);
        makeCell(hangkhoanchi,"Ghi chú",3,1);

        int sttkhoanchi = 0 ;
        int startrowphieutchi = sttrowthuchi+4 ;
        for(PhieuChi phieuChi : phieuChis){
            startrowphieutchi++;
            SXSSFRow rowtValue = sheet.createRow(startrowphieutchi);
            makeCell(rowtValue,String.valueOf(sttkhoanchi++),0,0);
            makeCell(rowtValue,phieuChi.getNoidungchi(),1,0);
            makeCell(rowtValue,String.valueOf(phieuChi.getSotien()),2,0);
            makeCell(rowtValue,phieuChi.getGhichu(),3,0);

        }



    }


    public void makeCell(SXSSFRow row,String value,int numberCell,int check){
        SXSSFCell cell = row.createCell(numberCell);
        cell.setCellValue(value);
        CellStyle cellStyle= sheet.getWorkbook().createCellStyle();

        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");

        font.setFontHeightInPoints((short) 11); // font size

        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setWrapText(true);
        if(check==1){
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            font.setBold(true);
        }
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cell.setCellStyle(cellStyle);

    }




    public  void createOutputFile(String excelFilePath, List<BaoCaoKho> baoCaoKhos, List<PhieuThu> phieuThus , List<PhieuChi> phieuChis) throws IOException {
        File file = new File(StringUtils.substringBeforeLast(excelFilePath, "/"));
        System.out.println(StringUtils.substringBeforeLast(excelFilePath, "/"));
        if (!file.exists()) {
            file.mkdirs();
        }

        writeContent(baoCaoKhos,phieuThus,phieuChis);

        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
            workbook.close();

        }
    }
}
