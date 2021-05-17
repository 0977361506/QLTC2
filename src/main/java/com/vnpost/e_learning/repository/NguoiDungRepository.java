package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.entities.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NguoiDungRepository extends JpaRepository<NguoiDung,Integer> {
    @Query(value="select * from nguoi_dung  where role = ?1",nativeQuery=true)
    public List<NguoiDung> findAllByViTri(Integer role);

    @Query(value="select * from nguoi_dung  where full_name like  ?1",nativeQuery=true)
    public List<NguoiDung> findAllByName(String name);

    @Transactional
    @Modifying
    @Query(value="  UPDATE nguoi_dung SET trangthai=?1 where id=?2"
            ,nativeQuery = true )
    public void updateTrangthai(
            Integer trangthai,
            Integer id
    ) ;

    @Transactional
    @Modifying
    @Query(value="  UPDATE nguoi_dung SET chucdanh =?1, email =?2," +
            " full_name=?3 ,image = ?4 , mand = ?5 ," +
            " phone=?6 , role = ?7 ,trangthai=?8 where id = ?9" ,nativeQuery = true )
    public void update(
            String chucdanh , String email , String fullname , String image , String mand , String phone,
            Integer role , Integer trangthai , Integer id
    ) ;


    @Transactional
    @Modifying
    @Query(value=" Insert INTO nguoi_dung (chucdanh,email , full_name ,image ," +
            " mand , phone , role , trangthai) VALUES (?1,?2,?3,?4,?5,?6,?7,?8)" ,nativeQuery = true )
    public void add(
            String chucdanh , String email , String fullname , String image , String mand , String phone,
            Integer role , Integer trangthai
    ) ;


}
