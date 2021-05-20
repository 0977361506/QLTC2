package com.vnpost.e_learning.service;

import com.vnpost.e_learning.bean.*;
import com.vnpost.e_learning.converter.GiaConverter;
import com.vnpost.e_learning.converter.KhoConverter;
import com.vnpost.e_learning.dto.GiaDTO;
import com.vnpost.e_learning.dto.KhoDTO;
import com.vnpost.e_learning.entities.Gia;
import com.vnpost.e_learning.entities.HangHoa;
import com.vnpost.e_learning.entities.Kho;
import com.vnpost.e_learning.repository.GiaRepository;
import com.vnpost.e_learning.repository.HanghoaRepository;
import com.vnpost.e_learning.repository.KhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KhoService {
    @Autowired
    private KhoRepository khoRepository ;
    @Autowired
    private HanghoaRepository hanghoaRepository ;
    @Autowired
    private KhoConverter khoConverter ;
    public List<KhoDTO> findAll(){
        return khoRepository.findAll().stream().map(item->khoConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public KhoDTO findByID(Integer id){
        return  khoConverter.convertToDTO(khoRepository.findById(id).get());
    }
    public void save(KhoDTO hangHoaDTO){
        Kho hangHoa = khoConverter.convertToEntity(hangHoaDTO);
        khoRepository.save(hangHoa);

    }

    public List<DanhSachNhapHang> danhsachnhaphang(String date) {
        ////select ct.hang_hoaid as maHH , ct.soluong as soluongnhap , ct.thang as thangnhap

        List<Tuple> tuples = khoRepository.laychitietphieunhap(date);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new DanhSachNhapHang(
                                    item.get("maHH", Integer.class),
                                    item.get("soluongnhap", Integer.class)

                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }


    public List<DanhSachBanHang> danhsachbanhang(String date) {

        List<Tuple> tuples = khoRepository.laychitiethoadon(date);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new DanhSachBanHang(
                                    item.get("maHH", Integer.class),
                                    item.get("soluongban", Integer.class)

                                    )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<DanhSachXuatHang> danhsachxuathang(String date) {

        List<Tuple> tuples = khoRepository.laychitietphieuxuat(date);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new DanhSachXuatHang(
                                    item.get("maHH", Integer.class),
                                    item.get("soluongxuat", Integer.class)

                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }


    public List<BaoCaoKho> baocaokho(String date) {

        List<DanhSachXuatHang>  danhsachxuathangs= danhsachxuathang(date);
        List<DanhSachNhapHang> danhSachNhapHangs = danhsachnhaphang(date);
        List<DanhSachBanHang> danhSachBanHangs = danhsachbanhang(date);
        List<HangHoa> hangHoas = hanghoaRepository.findAll();
        List<BaoCaoKho> baoCaoKhos = new ArrayList<>();
        for(HangHoa hangHoa : hangHoas){
            BaoCaoKho baoCaoKho = new BaoCaoKho();
            baoCaoKho.setMaCode(String.valueOf(hangHoa.getMaHH()));
            baoCaoKho.setMaHH(hangHoa.getId());
            baoCaoKho.setTenHH(hangHoa.getTenHH());
            baoCaoKho.setGia(hangHoa.getGia());
            baoCaoKho.setGiamgia(Float.parseFloat("0"));
            for(DanhSachNhapHang ds : danhSachNhapHangs){
                if(hangHoa.getId()==ds.getMaHH()){
                   baoCaoKho.setSoluongnhap(ds.getSoluongnhap());
                   hangHoa.setSoluong(hangHoa.getSoluong()+ds.getSoluongnhap());

                }
            }

            for(DanhSachXuatHang ds : danhsachxuathangs){
                if(hangHoa.getId()==ds.getMaHH()){
                    baoCaoKho.setSoluongxuat(ds.getSoluongxuat());
                    hangHoa.setSoluong(hangHoa.getSoluong()-ds.getSoluongxuat());
                }
            }

            for(DanhSachBanHang ds : danhSachBanHangs){
                if(hangHoa.getId()==ds.getMaHH()){
                    baoCaoKho.setSoluongbanra(ds.getSoluongban());
                    hangHoa.setSoluong(hangHoa.getSoluong()-ds.getSoluongban());
                }
            }
            baoCaoKho.setSoluongconlai(hangHoa.getSoluong());
            baoCaoKhos.add(baoCaoKho);
        }
        return baoCaoKhos;
    }


    public List<BaoCaoKho> baocaohanghoa(String date) {

        List<DanhSachBanHang> danhSachBanHangs = danhsachbanhang(date);
        List<HangHoa> hangHoas = hanghoaRepository.findAll();
        List<BaoCaoKho> baoCaoKhos = new ArrayList<>();
        for(HangHoa hangHoa : hangHoas){
            BaoCaoKho baoCaoKho = new BaoCaoKho();
            baoCaoKho.setMaCode(String.valueOf(hangHoa.getMaHH()));
            baoCaoKho.setMaHH(hangHoa.getId());
            baoCaoKho.setTenHH(hangHoa.getTenHH());

            baoCaoKho.setGia(hangHoa.getGia());
            baoCaoKho.setGiamgia(hangHoa.getGiamgia());

            for(DanhSachBanHang ds : danhSachBanHangs){
                if(hangHoa.getId()==ds.getMaHH()){
                    baoCaoKho.setSoluongbanra(ds.getSoluongban());

                }
            }

            baoCaoKhos.add(baoCaoKho);
        }
        return baoCaoKhos;
    }




}
