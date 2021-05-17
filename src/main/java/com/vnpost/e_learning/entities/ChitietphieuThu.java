package com.vnpost.e_learning.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Chitietphieunhap")
public class ChitietphieuThu {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Soluong")
    private int soluong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Giamgia")
    private float giamgia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Gia")
    private float gia;
    @JoinColumn(name = "HangHoaID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private HangHoa hangHoaID;
    @JoinColumn(name = "PhieunhapID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PhieuNhap phieunhapID;

}
