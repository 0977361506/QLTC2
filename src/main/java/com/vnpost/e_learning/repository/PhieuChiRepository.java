package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.PhieuChi;
import com.vnpost.e_learning.entities.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PhieuChiRepository extends JpaRepository<PhieuChi,Integer> {


    @Query(value="select * from phieu_chi",nativeQuery=true)
    public List<PhieuChi> findAll();

    @Query(value="select * from phieu_chi where ma_phieu_chi like ?1",nativeQuery=true)
    public List<PhieuChi> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO phieu_chi (doituongthanhtoan" +
            ",ghichu,ma_phieu_chi,ngaytao,noidungchi," +
            "sotk,sotien,ten_nguoi_nhan,nguoi_dungid) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)"

            ,nativeQuery=true)
    public void add(String doituong , String ghichu ,
                     String maphieu , String ngaytao,
                     String noidungthu , String sotk ,Float sotien , String tennguoinop ,
                     Integer idnguoidung);



}
