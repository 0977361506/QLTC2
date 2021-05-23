package com.vnpost.e_learning.service;

import com.vnpost.e_learning.bean.BaoCaoKho;
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
public class ExportBaoCaoPhieuChi {
    private SXSSFWorkbook workbook;
    private SXSSFSheet sheet;

    public ExportBaoCaoPhieuChi() {

    }


    public void writeContent( List<PhieuChi> phieuChis){

        createRowHeader("Chi tiết phiếu chi",17,1,1,
                0,3,1,0);
        int tieude = 3;
        sheet = workbook.getSheet("Chi tiết phiếu chi");
        SXSSFRow rowtieude = sheet.createRow(tieude);


        makeCell(rowtieude,"STT",0,1);
        makeCell(rowtieude,"Tên khoản chi",1,1);
        makeCell(rowtieude,"Số tiền",2,1);
        makeCell(rowtieude,"Ghi chú",3,1);


        int rownum = 4 ;
        int stt = 0 ;

        Double tongtien = 0.0 ;
            for(PhieuChi phieuChi : phieuChis){
                rownum++;
                SXSSFRow rowtValue = sheet.createRow(rownum);
                makeCell(rowtValue,String.valueOf(stt++),0,0);
                makeCell(rowtValue,phieuChi.getNoidungchi(),1,0);
                makeCell(rowtValue,String.valueOf(phieuChi.getSotien()),2,0);
                makeCell(rowtValue,phieuChi.getGhichu(),3,0);
                tongtien+=phieuChi.getSotien();
            }

        createRowHeader("Tổng tiền chi ra : "+tongtien ,12,
                6+phieuChis.size(),6+phieuChis.size(),0,3,
                6+phieuChis.size(),0);

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




    public  void createOutputFile(String excelFilePath,List<PhieuChi> phieuChis,SXSSFWorkbook newWorkbook) throws IOException {
        workbook = newWorkbook ;
        writeContent(phieuChis);

    }



    public void createRowHeader(String nameHeader,int fontsize , int firstRow , int lastRow ,
                                int firstCol, int lastcol, int rowNumber,int numberCell){

        sheet = workbook.getSheet("Chi tiết phiếu chi");
        Row rowheader = sheet.createRow(rowNumber);
        Cell cellheader = rowheader.createCell(numberCell);
        cellheader.setCellValue(nameHeader);
        CellStyle  cellStyle= workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        cellStyle.setFont(font);
        font.setFontHeightInPoints((short)fontsize);
        cellheader.setCellStyle(cellStyle);


        sheet.addMergedRegion(new CellRangeAddress(firstRow,lastRow,firstCol,lastcol));
    }

}
