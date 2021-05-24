package com.vnpost.e_learning.service;

import com.vnpost.e_learning.entities.BaoMat;
import com.vnpost.e_learning.entities.NguoiDung;
import com.vnpost.e_learning.repository.BaoMatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BaoMatService {
    @Autowired
    private BaoMatRepository baoMatRepository ;
    @Autowired
    HttpSession session ;
    public void save(String action , String noidung , String url  ){
        BaoMat baoMat = new BaoMat();
        baoMat.setAction(action);
        NguoiDung user = (NguoiDung) session.getAttribute("user");
        baoMat.setMaND(user.getId());
        baoMat.setNote(noidung);
        Date date = new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
        String dateString=sdf.format(date);
        baoMat.setTime(dateString);
        baoMat.setUrl(url);
        baoMatRepository.save(baoMat);
    }
}
