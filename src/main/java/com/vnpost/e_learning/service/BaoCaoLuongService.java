package com.vnpost.e_learning.service;

import com.vnpost.e_learning.bean.BaoCaoLuong;
import com.vnpost.e_learning.bean.PhieuBean;
import com.vnpost.e_learning.repository.ChamCongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaoCaoLuongService {
    @Autowired
    private ChamCongRepository chamCongRepository ;
    public List<BaoCaoLuong> baocaoluong(String date) {
        List<Tuple> tuples = chamCongRepository.baocaoluong(date);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new BaoCaoLuong(
                                    item.get("hoten", String.class),
                                    item.get("mand", String.class),
                                    item.get("chucdanh", String.class),
                                    item.get("mathue", String.class),
                                    item.get("tenthue", String.class),
                                    item.get("giatrithue", Double.class),
                                    item.get("heso", Double.class),
                                    item.get("luongcoban", Double.class),
                                    item.get("songaylamviec", Integer.class),
                                    item.get("thanglamviec", String.class)
                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }
}
