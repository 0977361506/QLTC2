package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.ChiPhi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiPhiRepository extends JpaRepository<ChiPhi,Integer> {
}
