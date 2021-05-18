
package com.vnpost.e_learning.bean;

        import lombok.Getter;
        import lombok.Setter;
        import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DanhSachXuatHang {
   // select ct.hang_hoaid as maHH , ct.soluong as soluongxuat , ct.thang as thangxuat
    private  Integer maHH ;
    private  Integer soluongxuat ;
    private String thangxuat ;

    public DanhSachXuatHang(Integer maHH, Integer soluongxuat) {
        this.maHH = maHH;
        this.soluongxuat = soluongxuat;

    }
    public DanhSachXuatHang() {

    }
}
