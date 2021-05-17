package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.entities.PhieuNhap;
import com.vnpost.e_learning.entities.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

public interface PhieuNhapRepository extends JpaRepository<PhieuNhap,Integer> {

    @Query(value="select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,\n" +
            "ncc.tenncc  , ncc.diachi , pn.id \n" +
            "from phieu_nhap as pn, nguoi_dung as nd , nha_cung_cap as ncc \n" +
            "where pn.nguoi_dungid = nd.id and pn.nha_cung_capid  = ncc.id" , nativeQuery=true)
    public List<Tuple>  getAllPhieuNhap();

    @Query(value="select chitiet.gia , chitiet.giamgia , chitiet.soluong ,\n" +
            "hh.mahh , hh.tenhh\n" +
            "from chitietphieunhap as chitiet , phieu_nhap as pn , hang_hoa as hh \n" +
            "where chitiet.phieunhapid = pn.id and chitiet.hang_hoaid = hh.id and pn.id = ?1" , nativeQuery=true)
    public List<Tuple>  getDetailPhieuNhap(Integer id);

    @Query(value="select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,\n" +
            "ncc.tenncc  , ncc.diachi , pn.id\n" +
            "from phieu_nhap as pn, nguoi_dung as nd , nha_cung_cap as ncc \n" +
            "where pn.nguoi_dungid = nd.id and pn.nha_cung_capid  = ncc.id and pn.id = ?1" , nativeQuery=true)
    public List<Tuple>  getInfoPhieunhap(Integer id);

    @Query(value="select * from phieu_nhap",nativeQuery=true)
    public List<PhieuNhap> findAll();

    @Transactional
    @Modifying
    @Query(value="INSERT INTO chitietphieunhap(gia,giamgia,soluong,hang_hoaid,phieunhapid) VALUES (?1, ?2, ?3 , ?4, ?5)",
            nativeQuery=true)
    public void saveChitietphieunhap(float gia , float giamgia , Integer soluong , Integer idhh  , Integer idphieunhap);

    @Query(value="select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,\n" +
            "ncc.tenncc  , ncc.diachi, pn.id\n" +
            "from phieu_nhap as pn, nguoi_dung as nd , nha_cung_cap as ncc \n" +
            "where pn.nguoi_dungid = nd.id and pn.nha_cung_capid  = ncc.id  and pn.ma_phieu like ?1",nativeQuery=true)
    public List<Tuple> timkiem(String name);


    @Transactional
    @Modifying
    @Query(value="  UPDATE phieu_nhap SET trangthai=?1 where id=?2"
            ,nativeQuery = true )
    public void updateStatus(
            Integer trangthai ,
            Integer khoachinh
    ) ;



}
