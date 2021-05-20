package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.entities.Kho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
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



    @Query(value="select ct.hang_hoaid as maHH , sum(ct.soluong) as soluongnhap \n" +
            "from phieu_nhap , chitietphieunhap  as ct\n" +
            "where phieu_nhap.id = ct.phieunhapid and ct.thang= ?1 \n" +
            "group by ct.hang_hoaid",nativeQuery=true)
    public List<Tuple> laychitietphieunhap(String thang);





    @Query(value="select ct.hang_hoaid as maHH ,sum(ct.soluong)  as soluongxuat \n" +
            "from phieu_xuat, chitietphieuxuat  as ct\n" +
            "where phieu_xuat.id = ct.phieu_xuatid and ct.thang=?1 \n" +
            "group by ct.hang_hoaid ",nativeQuery=true)
    public List<Tuple> laychitietphieuxuat(String thang);




    @Query(value="select ct.hang_hoaid as maHH , sum(ct.soluong) as soluongban \n" +
            "from hoa_don, chitiethoadon  as ct\n" +
            "where hoa_don.id = ct.hoa_donid and ct.thang=?1 \n" +
            "\n" +
            "group by ct.hang_hoaid ",nativeQuery=true)
    public List<Tuple> laychitiethoadon(String thang);

}
