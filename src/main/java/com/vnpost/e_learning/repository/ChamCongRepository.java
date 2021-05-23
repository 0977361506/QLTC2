package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

public interface ChamCongRepository extends JpaRepository<ChamCong,Integer> {
    @Query(value="select bangphu.hoten,bangphu.mand, bangphu.chucdanh ,bangphu.songaylamviec ,bangphu.thanglamviec,\n" +
            "thue.ma_thue  as mathue , thue.ten_thue as tenthue , thue.giatri as giatrithue ,\n" +
            " hsl.heso , luongthuong.luong_thuong as luongcoban\n" +
            "from (\n" +
            "select nd.full_name as hoten , nd.id , nd.mand , nd.chucdanh ,sum (cc.songaylamviec) as songaylamviec , cc.thang as thanglamviec\n" +
            "from nguoi_dung as nd ,  cham_cong as cc \n" +
            "where nd.id = cc.nguoi_dungid   and  cc.thang = ?1 \n" +
            "group by nd.id ,nd.full_name ,mand ,chucdanh,cc.thang\n" +
            ") as bangphu ,  thue ,he_so_luong as hsl , luong_thuong as luongthuong\n" +
            "where bangphu.id = thue.nguoi_dungid\n" +
            " and bangphu.id = hsl.nguoi_dungid \n" +
            " and luongthuong.nguoi_dungid = bangphu.id " , nativeQuery=true)
    public List<Tuple> baocaoluong(String date);


    public Boolean existsByNguoiDungIDAndNgaychamcong(NguoiDung idnv , String ngay);

    @Transactional
    @Modifying
    @Query(value="INSERT INTO cham_cong (ghichu,songaylamviec,nguoi_dungid,thang,ngaychamcong)" +
            " VALUES (?1,?2,?3,?4,?5)"
            ,nativeQuery=true)
    public void saveChamCong(String ghichu , Double songaylamviec  , Integer nguoi_dungid ,
                     String thang ,String ngaychamcong );
}
