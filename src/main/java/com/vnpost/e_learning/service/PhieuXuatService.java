package com.vnpost.e_learning.service;

import com.vnpost.e_learning.bean.PhieuBean;
import com.vnpost.e_learning.bean.PhieuChiTietBean;
import com.vnpost.e_learning.converter.PhieuThuConverter;
import com.vnpost.e_learning.dto.PhieuThuDTO;
import com.vnpost.e_learning.entities.*;
import com.vnpost.e_learning.entities.PhieuThu;
import com.vnpost.e_learning.repository.PhieuNhapRepository;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import com.vnpost.e_learning.repository.PhieuThuRepository;
import com.vnpost.e_learning.repository.PhieuXuatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhieuXuatService {
    @Autowired
    private PhieuThuRepository phieuThuRepository ;
    @Autowired
    private PhieuThuConverter phieuThuConverter ;
    public List<PhieuThuDTO> findAll(){
        return phieuThuRepository.findAll().stream().map(item->phieuThuConverter.convertToDTO(item))
                .collect(Collectors.toList()) ;
    }

    public PhieuThuDTO findByID(Integer id){
        return  phieuThuConverter.convertToDTO(phieuThuRepository.findById(id).get());
    }
    public void save(PhieuThuDTO hangHoaDTO){
        PhieuThu hangHoa = phieuThuConverter.convertToEntity(hangHoaDTO);
        phieuThuRepository.save(hangHoa);

    }



    @Autowired
    private PhieuXuatRepository phieuXuatRepository ;
    @Autowired
    private EntityManager entityManager;

    public List<PhieuBean> getALLPhieuNhap() {
        //select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,
        //ncc.tenncc  , ncc.diachi
        List<Tuple> tuples = phieuXuatRepository.getAllPhieuXuat();
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new PhieuBean(
                                    item.get("maphieu", String.class),
                                    item.get("ghichu", String.class),
                                    item.get("trangthai", Integer.class),
                                    item.get("nguoitao", String.class),
                                    item.get("tenncc", String.class),
                                    item.get("diachi", String.class),
                                    item.get("ngaytao", String.class),
                                    item.get("id", Integer.class)
                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<PhieuChiTietBean> getDetail(Integer id) {


        List<Tuple> tuples = phieuXuatRepository.getDetailPhieuNhap(id);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new PhieuChiTietBean(
                                    item.get("gia", Double.class),
                                    item.get("giamgia", Double.class),
                                    item.get("soluong", Integer.class),
                                    item.get("mahh", Integer.class),
                                    item.get("tenhh", String.class)
                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;

    }


    public List<PhieuBean> getInfoPhieuNhap(Integer id) {

        List<Tuple> tuples = phieuXuatRepository.getInfoPhieuxuat(id);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new PhieuBean(
                                    item.get("maphieu", String.class),
                                    item.get("ghichu", String.class),
                                    item.get("trangthai", Integer.class),
                                    item.get("nguoitao", String.class),
                                    item.get("tenncc", String.class),
                                    item.get("diachi", String.class),
                                    item.get("ngaytao", String.class),
                                    item.get("id", Integer.class)
                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }

    public Object[] getInfoDetail(Integer id) {
        List<PhieuChiTietBean> chiTietBeans = getDetail(id);
        List<PhieuBean> phieuBeans = getInfoPhieuNhap(id);
        PhieuBean phieuBean = (phieuBeans.size() > 0) ? phieuBeans.get(0) : null;
        Object[] objects = {phieuBean, chiTietBeans};
        return objects;
    }

    @Transactional
    @Modifying
    public void save(PhieuXuat phieuXuat) {

        String hql = "INSERT INTO phieu_xuat (ma_phieu,ghichu,nguoi_dungid,dai_lyid,trangthai,ngaytao) VALUES (:a, :b, :c,:d, :e, :f)";

        entityManager.createNativeQuery(hql).
                setParameter("a", phieuXuat.getMaPhieu())
                .setParameter("b", phieuXuat.getGhichu()).
                setParameter("c", phieuXuat.getMaND())
                .setParameter("d", phieuXuat.getMaNCC()).setParameter("e", 1)
                .setParameter("f", phieuXuat.getNgaytao()).executeUpdate();

    }

    public void saveDetail(HangHoa hangHoa , Integer idPhieunhap){
        phieuXuatRepository.saveChitietphieuxuat(hangHoa.getGia(),hangHoa.getGiamgia(),hangHoa.getSoluong(),hangHoa.getId(),idPhieunhap);
    }
    public void saveALL(Collection<HangHoa> hangHoas , Integer idPhieuNhap){
        for(HangHoa hangHoa : hangHoas){
            saveDetail(hangHoa,idPhieuNhap);
        }
    }


    public List<PhieuBean> timkiem(String name) {
        //select pn.ma_phieu as maphieu , pn.ghichu , pn.ngaytao , pn.trangthai , nd.full_name as nguoitao ,
        //ncc.tenncc  , ncc.diachi
        List<Tuple> tuples = phieuXuatRepository.timkiem(name);
        if (tuples != null) {
            return tuples.stream()
                    .map(
                            item -> new PhieuBean(
                                    item.get("maphieu", String.class),
                                    item.get("ghichu", String.class),
                                    item.get("trangthai", Integer.class),
                                    item.get("nguoitao", String.class),
                                    item.get("tenncc", String.class),
                                    item.get("diachi", String.class),
                                    item.get("ngaytao", String.class),
                                    item.get("id", Integer.class)
                            )
                    )
                    .collect(Collectors.toList());
        }
        return null;
    }




}
