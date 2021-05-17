package com.vnpost.e_learning.api;

import com.vnpost.e_learning.entities.Report;
import com.vnpost.e_learning.repository.ReportRepository;
import com.vnpost.e_learning.service.ExcellServiceOutputExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportApi {
    @Autowired
    ReportRepository reportRepository ;

    @GetMapping("/report/{code}")
    public List<Report> findAllByCode(@PathVariable("code") Integer code){
        return  reportRepository.findAllByCode(code);
    }

    // /report/export

    @GetMapping("/report/export")
    public String  export ()  throws IOException {
        ExcellServiceOutputExporter excellServiceOutputExporter = new ExcellServiceOutputExporter();
    String path = "D://postman-delivery//report//collection-salary//"+"baocaoQLTC.xlsx" ;
        excellServiceOutputExporter.createOutputFile(path);
        return  "baocao.xlsx" ;
    }
}
