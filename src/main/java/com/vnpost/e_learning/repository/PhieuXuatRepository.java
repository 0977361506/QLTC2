package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.PhieuNhap;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.entities.PhieuXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

public interface PhieuXuatRepository extends JpaRepository<PhieuXuat,Integer> {

    @Query(value="select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,\n" +
            "ncc.tendl as tenncc  , ncc.diachi, pn.id\n" +
            "from phieu_xuat as pn, nguoi_dung as nd , dai_ly as ncc \n" +
            "where pn.nguoi_dungid = nd.id and pn.dai_lyid  = ncc.id " , nativeQuery=true)
    public List<Tuple> getAllPhieuXuat();

    @Query(value="\n" +
            "select chitiet.gia , chitiet.giamgia , chitiet.soluong ,\n" +
            "hh.mahh , hh.tenhh\n" +
            "from chitietphieuxuat as chitiet , phieu_xuat as pn , hang_hoa as hh \n" +
            "where chitiet.phieu_xuatid = pn.id and chitiet.hang_hoaid = hh.id and pn.id =?1" , nativeQuery=true)
    public List<Tuple>  getDetailPhieuNhap(Integer id);

    @Query(value="select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,\n" +
            "ncc.tendl as tenncc  , ncc.diachi, pn.id\n" +
            "from phieu_xuat as pn, nguoi_dung as nd , dai_ly as ncc \n" +
            "where pn.nguoi_dungid = nd.id and pn.dai_lyid  = ncc.id " , nativeQuery=true)
    public List<Tuple>  getInfoPhieuxuat(Integer id);

    @Query(value="select * from phieu_xuat",nativeQuery=true)
    public List<PhieuXuat> findAll();

    @Transactional
    @Modifying
    @Query(value="INSERT INTO chitietphieuxuat(gia,giamgia,soluong,hang_hoaid,phieu_xuatid) VALUES (?1, ?2, ?3 , ?4, ?5)",
            nativeQuery=true)
    public void saveChitietphieuxuat(float gia , float giamgia , Integer soluong , Integer idhh  , Integer idphieunhap);

    @Query(value="select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,\n" +
            "ncc.tendl as tenncc  , ncc.diachi, pn.id\n" +
            "from phieu_xuat as pn, nguoi_dung as nd , dai_ly as ncc \n" +
            "where pn.nguoi_dungid = nd.id and pn.dai_lyid  = ncc.id  and pn.ma_phieu like ?1",nativeQuery=true)
    public List<Tuple> timkiem(String name);


    @Transactional
    @Modifying
    @Query(value="  UPDATE phieu_xuat SET trangthai=?1 where id=?2"
            ,nativeQuery = true )
    public void updateStatus(
            Integer trangthai ,
            Integer khoachinh
    ) ;



}
