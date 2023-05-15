package com.example.thi_md4.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
@Entity
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "ma_du_an")
    @Pattern(regexp = "DA-\\d{4}", message = "vui lòng nhập đúng định dạng (DA-****)")
    private String maDuAn;
    @Column(name = "ten_du_an")

    private String tenDuAn;
    @Column(name = "ten_doanh_nghiep")
    @NotEmpty
    private String tenDoanhNghiep;
    @Column(name = "kinh_phi_du_an")
    @NotEmpty
    private Integer kinhPhiDuAn;
    @Column(name = "thoi_gian_dky_gioi_thieu")
    @NotEmpty
    @Min(value = 2, message = "Số tháng không được âm và lớn hơn 1")
    @Max(value = 12, message = "Số tháng không được âm và bé hơn 12")
    private String thoiGianDangKyGioiThieu;
    @Column(name = "ngay_dang_ky")
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ngayDangKy;
    @Column(name = "chi_phi")
    @NotEmpty
    private String chiPhi;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyA;

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getTenDoanhNghiep() {
        return tenDoanhNghiep;
    }

    public void setTenDoanhNghiep(String tenDoanhNghiep) {
        this.tenDoanhNghiep = tenDoanhNghiep;
    }

    public Integer getKinhPhiDuAn() {
        return kinhPhiDuAn;
    }

    public void setKinhPhiDuAn(Integer kinhPhiDuAn) {
        this.kinhPhiDuAn = kinhPhiDuAn;
    }

    public String getThoiGianDangKyGioiThieu() {
        return thoiGianDangKyGioiThieu;
    }

    public void setThoiGianDangKyGioiThieu(String thoiGianDangKyGioiThieu) {
        this.thoiGianDangKyGioiThieu = thoiGianDangKyGioiThieu;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public String getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(String chiPhi) {
        this.chiPhi = chiPhi;
    }

    public Company getCompanyA() {
        return companyA;
    }

    public void setCompanyA(Company companyA) {
        this.companyA = companyA;
    }
}
