package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.DanhMucKho;
import com.vnpost.e_learning.entities.Kho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DanhMucKhoRepository extends JpaRepository<DanhMucKho,Integer> {
    @Query(value="select * from danh_muc_kho",nativeQuery=true)
    public List<DanhMucKho> findAll();

    @Query(value="select * from danh_muc_kho where tendm like ?1",nativeQuery=true)
    public List<DanhMucKho> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="  UPDATE danh_muc_kho SET tendm =?1, ngaytao =?2  where id=?3"
            ,nativeQuery = true )
    public void savedanhmuc(
            String tenkho ,
            String ngaytao,
            Integer khoachinh
    ) ;

    @Transactional
    @Modifying
    @Query(value="INSERT INTO danh_muc_kho (tendm,ngaytao) VALUES (?1,?2)"
            ,nativeQuery=true)
    public void add( String tenkho ,
                     String ngaytao );

}
