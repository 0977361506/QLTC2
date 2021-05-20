package com.vnpost.e_learning.controller;

import com.vnpost.e_learning.common.DownloadUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/download")
public class ReportController {
    @GetMapping("/baocaoluong")
    public void downloadTemplate(@RequestParam(name = "nameFile")  String nameFile, HttpServletResponse response)
            throws IOException {
        File file = new File("D://postman-delivery//report//baocaocoha//" + nameFile);
        try {
            DownloadUtils.download(response, file);
        } catch (Exception e) {
            response.sendRedirect("/admin/luong/tinhluongnhanvien");
        }
    }

    @GetMapping("/baocaokho")
    public void downloadTemplatekho(@RequestParam(name = "nameFile")  String nameFile, HttpServletResponse response)
            throws IOException {
        File file = new File("D://postman-delivery//report//baocaocoha//" + nameFile);
        try {
            DownloadUtils.download(response, file);
        } catch (Exception e) {
            response.sendRedirect("/admin/baocao/baocaokho");
        }
    }

    @GetMapping("/baocaobanhang")
    public void baocaobanhang(@RequestParam(name = "nameFile")  String nameFile, HttpServletResponse response)
            throws IOException {
        File file = new File("D://postman-delivery//report//baocaocoha//" + nameFile);
        try {
            DownloadUtils.download(response, file);
        } catch (Exception e) {
            response.sendRedirect("/admin/baocao/baocaobanhang");
        }
    }

}