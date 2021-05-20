package  com.vnpost.e_learning.service;

        import com.vnpost.e_learning.bean.BaoCaoKho;
        import com.vnpost.e_learning.bean.BaoCaoLuong;
        import lombok.Getter;
        import lombok.Setter;
        import org.apache.commons.lang3.StringUtils;
        import org.apache.poi.ss.usermodel.*;
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
public class ExportBaoCaoBanHang {
    private SXSSFWorkbook workbook;
    private SXSSFSheet sheet;

    public ExportBaoCaoBanHang() {
        workbook = new SXSSFWorkbook(10000000);
    }



    public void writeContent(List<BaoCaoKho> baoCaoKhos){


        int tieude = 1;
        sheet = workbook.createSheet("báo cáo bán hàng");
        SXSSFRow rowtieude = sheet.createRow(tieude);


        makeCell(rowtieude,"STT",0,1);
        makeCell(rowtieude,"Mã hàng hóa",1,1);
        makeCell(rowtieude,"Mã code",2,1);
        makeCell(rowtieude,"Tên hàng hóa",3,1);
        makeCell(rowtieude,"Giá bán ra",4,1);
        makeCell(rowtieude,"Số lượng bán ra",5,1);


        int rownum = 2 ;
        int stt = 0 ;
        Double tongtien = 0.0 ;
        for (BaoCaoKho baoCaoKho : baoCaoKhos) {
            rownum++;
            SXSSFRow rowtValue = sheet.createRow(rownum);

            String soluongbanra = (baoCaoKho.getSoluongbanra()!=null)?baoCaoKho.getSoluongbanra().toString() : "0" ;
            tongtien+= (Integer.parseInt(soluongbanra)*baoCaoKho.getGia());
            makeCell(rowtValue,String.valueOf(stt++),0,0);
            makeCell(rowtValue,baoCaoKho.getMaHH().toString(),1,0);
            makeCell(rowtValue,baoCaoKho.getMaCode(),2,0);
            makeCell(rowtValue,baoCaoKho.getTenHH(),3,0);
            makeCell(rowtValue,baoCaoKho.getGia().toString(),4,0);
            makeCell(rowtValue,soluongbanra,5,0);

        }

        int stttongtien = 4+baoCaoKhos.size();
        SXSSFRow rowtongtien = sheet.createRow(stttongtien);
        makeCell(rowtongtien,"Doanh thu = ",3,1);
        makeCell(rowtongtien,tongtien.toString(),4,1);

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




    public  void createOutputFile(String excelFilePath, List<BaoCaoKho> baoCaoKhos) throws IOException {
        File file = new File(StringUtils.substringBeforeLast(excelFilePath, "/"));
        System.out.println(StringUtils.substringBeforeLast(excelFilePath, "/"));
        if (!file.exists()) {
            file.mkdirs();
        }

        writeContent(baoCaoKhos);

        try (OutputStream os = new FileOutputStream(excelFilePath)) {
            workbook.write(os);
            workbook.close();

        }
    }
}
