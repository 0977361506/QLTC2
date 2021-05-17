package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.entities.Kho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface KhoRepository extends JpaRepository<Kho,Integer> {
    @Query(value="select * from kho",nativeQuery=true)
    public List<Kho> findAll();

    @Query(value="select * from kho where ten_kho like ?1",nativeQuery=true)
    public List<Kho> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="  UPDATE kho SET ten_kho =?1, ngaytao =?2 , danh_muc_khoid = ?3  where id=?4"
            ,nativeQuery = true )
    public void savedanhmuc(
            String tenkho ,
            String ngaytao, Integer iddm ,
            Integer khoachinh
    ) ;

    @Transactional
    @Modifying
    @Query(value="INSERT INTO kho (ten_kho,ngaytao,danh_muc_khoid) VALUES (?1,?2,?3)"
            ,nativeQuery=true)
    public void add( String tenkho ,
                     String ngaytao ,Integer iddm);
}
