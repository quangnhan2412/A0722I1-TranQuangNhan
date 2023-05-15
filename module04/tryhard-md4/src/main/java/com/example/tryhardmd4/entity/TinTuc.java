package com.example.tryhardmd4.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class TinTuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tieu_de")
    @NotBlank(message = "Vui lòng nhập tiêu đề !")
    @Size(min = 5, max=50, message = "không quá 50 ký tự")
    private String tieuDe;
    @Column(name = "noi_dung")
    @NotBlank(message = "Vui lòng nhập nội dung !")
    @Size(min = 5, max=500, message = "không quá 500 ký tự")

    private String noiDung;
    @Column(name = "ngay_dang_tin")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ngayDangTin;
    @Column(name = "phong_vien")
    @NotBlank(message = "Vui lòng nhập phóng viên !")
    private String phongVien;

    @ManyToOne
    @JoinColumn(name = "danhmuc_id")
    private DanhMuc danhMuc;


    public void setNgayDangTin() {
        java.util.Date date=new java.util.Date();
        this.ngayDangTin = date;
    }
}
