package com.vnpost.e_learning.service;

import java.io.*;
import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.vnpost.e_learning.bean.BaoCaoLuong;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class ExcellServiceOutputExporter {
    private SXSSFWorkbook workbook;
    private SXSSFSheet sheet;

    public ExcellServiceOutputExporter() {
        workbook = new SXSSFWorkbook(10000000);
    }



    public void writeContent(List<BaoCaoLuong> baoCaoLuongs){


        int tieude = 1;
        sheet = workbook.createSheet("báo cáo lương");
        SXSSFRow rowtieude = sheet.createRow(tieude);


        makeCell(rowtieude,"STT",0,1);
        makeCell(rowtieude,"Mã nhân viên",1,1);
        makeCell(rowtieude,"Tên nhân viên",2,1);
        makeCell(rowtieude,"Chức danh",3,1);
        makeCell(rowtieude,"Mã thuế",4,1);
        makeCell(rowtieude,"Loại thuế",5,1);
        makeCell(rowtieude,"Hệ số lương",6,1);
        makeCell(rowtieude,"Mức lương",7,1);
        makeCell(rowtieude,"Số ngày làm việc",8,1);
        makeCell(rowtieude,"Tiền thuế",9,1);
        makeCell(rowtieude,"Tổng tiền được nhận",10,1);


        int rownum = 2 ;
        int stt = 0 ;
        for (BaoCaoLuong baoCaoLuong : baoCaoLuongs) {
            rownum++;
            SXSSFRow rowtValue = sheet.createRow(rownum);
            Double tongtien = (baoCaoLuong.getHeso()*baoCaoLuong.getLuongcoban()*baoCaoLuong.getSongaylamviec())-baoCaoLuong.getGiatrithue();
            makeCell(rowtValue,String.valueOf(stt++),0,0);
            makeCell(rowtValue,baoCaoLuong.getMand(),1,0);
            makeCell(rowtValue,baoCaoLuong.getHoten(),2,0);
            makeCell(rowtValue,baoCaoLuong.getChucdanh(),3,0);
            makeCell(rowtValue,baoCaoLuong.getMathue(),4,0);
            makeCell(rowtValue,baoCaoLuong.getTenthue(),5,0);
            makeCell(rowtValue,baoCaoLuong.getHeso().toString(),6,0);
            makeCell(rowtValue,baoCaoLuong.getLuongcoban().toString(),7,0);
            makeCell(rowtValue,baoCaoLuong.getSongaylamviec().toString(),8,0);
            makeCell(rowtValue,baoCaoLuong.getGiatrithue().toString(),9,0);
            makeCell(rowtValue,tongtien.toString(),10,1);


        }

    }


    public void makeCell(SXSSFRow row,String value,int numberCell,int check){
        SXSSFCell cell = row.createCell(numberCell);
        cell.setCellValue(value);
        CellStyle  cellStyle= sheet.getWorkbook().createCellStyle();

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




    public  void createOutputFile(String excelFilePath, List<BaoCaoLuong> baoCaoLuongs) throws IOException {
        File file = new File(StringUtils.substringBeforeLast(excelFilePath, "/"));
        System.out.println(StringUtils.substringBeforeLast(excelFilePath, "/"));
        if (!file.exists()) {
            file.mkdirs();
        }

        writeContent(baoCaoLuongs);

        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
            workbook.close();

        }
    }




}
