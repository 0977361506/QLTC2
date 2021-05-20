package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.LuongThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LuongthuongRepository extends JpaRepository<LuongThuong,Integer> {
}
