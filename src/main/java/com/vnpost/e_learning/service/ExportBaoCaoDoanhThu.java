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

    }



    public void writeContent(List<BaoCaoKho> baoCaoKhos){

        createRowHeader("Báo cáo tồn kho theo tháng");

        int tieude = 3;
        sheet = workbook.getSheet("Báo cáo tồn kho");
        SXSSFRow rowtieude = sheet.createRow(tieude);


        makeCell(rowtieude,"STT",0,1);
        makeCell(rowtieude,"Mã hàng hóa",1,1);
        makeCell(rowtieude,"Mã code",2,1);
        makeCell(rowtieude,"Tên hàng hóa",3,1);
        makeCell(rowtieude,"Số lượng nhập",4,1);
        makeCell(rowtieude,"Số lượng xuất",5,1);
        makeCell(rowtieude,"Số lượng bán ra",6,1);
        makeCell(rowtieude,"Số lượng còn lại",7,1);


        int rownum = 4 ;
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




    public  void createOutputFile(String excelFilePath,
                                  List<BaoCaoKho> baoCaoKhos ,SXSSFWorkbook newWorkbook
     ) throws IOException {
        workbook =  newWorkbook;
        writeContent(baoCaoKhos);

    }

    public void createRowHeader(String nameHeader){

        sheet = workbook.getSheet("Báo cáo tồn kho");
        Row rowheader = sheet.createRow(1);
        Cell cellheader = rowheader.createCell(0);
        cellheader.setCellValue(nameHeader);
        CellStyle  cellStyle= workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        cellStyle.setFont(font);
        font.setFontHeightInPoints((short)16);
        cellheader.setCellStyle(cellStyle);


        sheet.addMergedRegion(new CellRangeAddress(1,1,0,7));
    }

}
