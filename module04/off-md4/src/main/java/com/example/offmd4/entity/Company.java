package com.example.offmd4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    private Integer companyId;
    @Column(name = "ten_cong_ty")
    @NotBlank
    private String tenCongTy;
    @Column(name = "ten_cong_ty")
    @NotBlank
    private String linhVucKinhDoanh;
    @Column(name = "so_dien_thoai")
    @NotBlank
    private String soDienThoai;
    @Email
    private String email;
    @Column(name = "dia_chi")
    @NotBlank
    private  String diaChi;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DuAn> duAns;
}
