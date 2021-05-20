package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.ChamCong;
import com.vnpost.e_learning.entities.Thue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThueRepository extends JpaRepository<Thue,Integer> {
}
