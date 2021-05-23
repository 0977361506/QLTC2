package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.entities.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PhieuThuRepository extends JpaRepository<PhieuThu,Integer> {
    @Query(value="select * from phieu_thu",nativeQuery=true)
    public List<PhieuThu> findAll();

    @Query(value="select * from phieu_thu where ma_phieu_thu like ?1",nativeQuery=true)
    public List<PhieuThu> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO phieu_thu (diachi_thu," +
            "doituong,ghichu,ma_phieu_thu,ngaytao,noiidung_thu," +
            "sotk,sotien,tennguoinop,nguoi_dungid) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)"
            ,nativeQuery=true)
    public void add( String diachi ,String doituong , String ghichu ,
                     String maphieu , String ngaytao,
                     String noidungthu , String sotk ,Float sotien , String tennguoinop ,
                     Integer idnguoidung);


    @Query(value="select * from phieu_thu where thang= ?1",nativeQuery=true)
    public List<PhieuThu> layphieuthutheothang(String thang);
}
