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

@Getter
@Setter
@Component
public class ExcellServiceOutputExporter {
    private SXSSFWorkbook workbook;
    private SXSSFSheet sheet;

    public ExcellServiceOutputExporter() {
        workbook = new SXSSFWorkbook(10000000);
    }



    public void writeContent(){
        String title = "BẢNG TỔNG HỢP TIỀN LƯƠNG/THÙ LAO CÔNG PHÁT THÁNG ";

        sheet = workbook.createSheet("Bưu tá");
        SXSSFRow rowheader = sheet.createRow(0);
        SXSSFCell cellheader = rowheader.createCell(0);
        cellheader.setCellValue("TỔNG CÔNG TY \n BƯU ĐIỆN VIỆT NAM \n");
        CellStyle cellStyle= workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellheader.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0,3,0,3));

        SXSSFRow rowTiltle = sheet.createRow(5); // tieu đê
        SXSSFCell cellTiltle = rowTiltle.createCell(0);
        cellTiltle.setCellValue(title);
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        cellStyle.setFont(font);
        cellTiltle.setCellStyle(cellStyle);



    }




    public  void createOutputFile( String excelFilePath) throws IOException {
        File file = new File(StringUtils.substringBeforeLast(excelFilePath, "/"));
        System.out.println(StringUtils.substringBeforeLast(excelFilePath, "/"));
        if (!file.exists()) {
            file.mkdirs();
        }

        writeContent();

        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
            workbook.close();

        }
    }




}
