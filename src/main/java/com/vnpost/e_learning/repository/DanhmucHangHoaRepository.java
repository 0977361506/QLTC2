package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.entities.HangHoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DanhmucHangHoaRepository extends JpaRepository<DanhMucHangHoa,Integer> {

    @Query(value="select * from danh_muc_hang_hoa",nativeQuery=true)
    public List<DanhMucHangHoa> findAll();

    @Query(value="select * from danh_muc_hang_hoa where tendm like ?1",nativeQuery=true)
    public List<DanhMucHangHoa> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="  UPDATE danh_muc_hang_hoa SET tendm=?1, khoid =?2 , ngaytao = ?3 where id=?4"
             ,nativeQuery = true )
    public void savedanhmuc(

            String tenhh ,
            Integer idkho,
            String ngaytao,
            Integer khoachinh
    ) ;

    @Transactional
    @Modifying
    @Query(value="INSERT INTO danh_muc_hang_hoa (tendm,khoid,ngaytao) VALUES (?1,?2,?3)"
            ,nativeQuery=true)
    public void add( String tenhh ,
                     Integer pk,String ngaytao);

}
