package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface ChamCongRepository extends JpaRepository<ChamCong,Integer> {
    @Query(value="select nd.full_name as hoten , nd.mand , nd.chucdanh ,\n" +
            "thue.ma_thue  as mathue , thue.ten_thue as tenthue , thue.giatri as giatrithue ,\n" +
            "hsl.heso , luongthuong.luong_thuong as luongcoban , cc.songaylamviec , cc.thang as thanglamviec\n" +
            "from nguoi_dung as nd , \n" +
            "thue ,he_so_luong as hsl ,\n" +
            "cham_cong as cc , luong_thuong as luongthuong\n" +
            "where nd.id = thue.nguoi_dungid\n" +
            "and nd.id = hsl.nguoi_dungid \n" +
            "and nd.id = cc.nguoi_dungid \n" +
            "and luongthuong.nguoi_dungid = nd.id\n" +
            "and  cc.thang = ?1" , nativeQuery=true)
    public List<Tuple> baocaoluong(String date);
}
