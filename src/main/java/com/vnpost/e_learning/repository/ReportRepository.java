package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChiPhi;
import com.vnpost.e_learning.entities.DanhMucKho;
import com.vnpost.e_learning.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Integer> {
    @Query(value="select * from report where code = ?1",nativeQuery=true)
    public List<Report> findAllByCode(Integer code);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO report(ten,nguoitao,ngaytao,code) VALUES (?1, ?2, ?3 , ?4)",
            nativeQuery=true)
    public void saveReport(String ten , String nguoitao , String ngaytao , Integer code) ;

}
