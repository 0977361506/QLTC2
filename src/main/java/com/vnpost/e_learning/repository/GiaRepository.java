package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.DanhMucHangHoa;
import com.vnpost.e_learning.entities.Gia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GiaRepository extends JpaRepository<Gia,Integer> {

    @Query(value="select * from gia",nativeQuery=true)
    public List<Gia> findAll();

    @Query(value="select * from gia where ten_gia like ?1",nativeQuery=true)
    public List<Gia> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="  UPDATE gia SET ten_gia=?1, gia =?2 , ghichu = ?3 ,hang_hoaid=?4 where id=?5"
            ,nativeQuery = true )
    public void savedanhmuc(

            String tenhh ,
            float gia,
            String ghichu, Integer idhanghoa ,
            Integer khoachinh
    ) ;

    @Transactional
    @Modifying
    @Query(value="INSERT INTO gia (ten_gia,gia,ghichu,hang_hoaid) VALUES (?1,?2,?3,?4)"
            ,nativeQuery=true)
    public void add( String tenhh , float gia ,
                     String ghichu ,Integer idhanghoa);
}
