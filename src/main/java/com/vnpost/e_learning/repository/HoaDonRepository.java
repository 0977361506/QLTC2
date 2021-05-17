package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoaDonRepository extends JpaRepository<HoaDon,Integer> {
}
