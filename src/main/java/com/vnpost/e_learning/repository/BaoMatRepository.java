package com.vnpost.e_learning.repository;

import com.vnpost.e_learning.entities.BaoMat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaoMatRepository extends JpaRepository<BaoMat,Integer> {
    public List<BaoMat> findAllByMaND(Integer idND);
}
