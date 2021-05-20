package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.NhomKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhomKhachHangRepository extends JpaRepository<NhomKhachHang,Integer> {
}
