package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChiPhi;
import com.vnpost.e_learning.entities.DanhMucKho;
import com.vnpost.e_learning.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Integer> {
    @Query(value="select * from report where code = ?1",nativeQuery=true)
    public List<Report> findAllByCode(Integer code);
}
