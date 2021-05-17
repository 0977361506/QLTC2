package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.HangHoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HanghoaRepository extends JpaRepository<HangHoa,Integer> {
    public List<HangHoa> findByMaHH(Integer maHH);

    @Query(value="select * from hang_hoa",nativeQuery=true)
    public List<HangHoa> findAll();

    @Query(value="select * from hang_hoa where tenhh like ?1",nativeQuery=true)
    public List<HangHoa> timkiem(String name);

    @Transactional
    @Modifying
    @Query(value="  UPDATE hang_hoa SET giamgia =?1, gia =?2," +
            " image=?3 ,mahh = ?4 , mieuta = ?5 ," +
            " new=?6 , danh_muc_hang_hoaid = ?7 ,tenhh=?8 where mahh = ?9" ,nativeQuery = true )
    public void saveHangHoa(
            float giamgia , float gia , String image , Integer mahh , String mieuta , Integer new1 , Integer iddm ,
            String tenhh ,
            Integer pk
    ) ;

    @Transactional
    @Modifying
    @Query(value="INSERT INTO hang_hoa (giamgia,gia,image,mahh,mieuta,new,danh_muc_hang_hoaid,tenhh) VALUES (?1,?2,?3,?4,?5,?6,?7,?8)"
            ,nativeQuery=true)
    public void add(float giamgia , float gia , String image  , Integer mahh , String mieuta , Integer new1 ,Integer iddm ,String tenhh );

}
