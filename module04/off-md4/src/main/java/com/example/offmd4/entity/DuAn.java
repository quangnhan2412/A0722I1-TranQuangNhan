package com.example.offmd4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DuAn {
    @Id
    @GeneratedValue
    @Column(name = "ma_du_an")
    @Pattern(regexp = "DA-\\d{4}", message = "vui lòng nhập đúng định dạng (DA-****)")
    private String maDuAn;
    @Column(name = "ten_du_an")
    @NotBlank
    private String tenDuAn;
    @Column(name = "ten_doanh_nghiep")
    @NotBlank
    private String tenDoanhNghiep;
    @Column(name = "kinh_phi_du_an")
    @NotBlank
    private Integer kinhPhiDuAn;
    @Column(name = "thoi_gian_dky_gioi_thieu")
    @NotBlank
    @Min(value = 2, message = "Số tháng không được âm và lớn hơn 1")
    @Max(value = 12, message = "Số tháng không được âm và bé hơn 12")
    private String thoiGianDangKyGioiThieu;
    @Column(name = "ngay_dang_ky")
    @NotBlank
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ngayDangKy;
    @Column(name = "chi_phi")
    @NotBlank
    private String chiPhi;
@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

}
