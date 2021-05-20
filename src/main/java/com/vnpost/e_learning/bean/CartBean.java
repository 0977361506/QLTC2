package com.vnpost.e_learning.bean;

import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.repository.HanghoaRepository;
import com.vnpost.e_learning.service.HangHoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

@Service
public class CartBean {

    public static Map<Integer, HangHoa> listDish = new HashMap<Integer, HangHoa>();

    @Autowired
    private HanghoaRepository hangHoaService ;


    public Map<Integer, HangHoa> getListDish() {
        return listDish;
    }


    public static void setListDish(Map<Integer, HangHoa> listDish) {
        CartBean.listDish = listDish;
    }

    public boolean addToCart(int id) {
        HangHoa dish = listDish.get(id);
        if( dish==null) {
            dish = hangHoaService.findById(id).get();

            dish.setSoluong(1);
            listDish.put(id,dish);

        }else {
                dish.setSoluong(dish.getSoluong()+1);
        }
        return true ;
    }

    public boolean updateQuantity(int id,int soluong) {
        HangHoa dish = listDish.get(id);
        if( dish==null) {
            dish = hangHoaService.findById(id).get();

            dish.setSoluong(1);
            listDish.put(id,dish);

        }else {
            dish.setSoluong(soluong);
        }
        return true ;
    }


    public void remove(int id) {
        listDish.remove(id);
    }

    public Collection<HangHoa> getList() {
        return listDish.values();
    }

    public float getToTalPrice() {
        float tongtien = 0;
        Collection<HangHoa> dishs = this.getList();
        for(HangHoa b: dishs) {
            tongtien+= b.getSoluong()*(b.getGia()); //tongtien+= a.getSldatmon()*(a.getGia()*(1-a.getGiamgia()/100));
        }
        return tongtien;
    }

    public void deleteBook(int id) {
        listDish.remove(id);
    }

    public void removeAll() {
        listDish.clear();
    }


}
