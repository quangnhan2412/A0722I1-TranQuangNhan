package com.example.thi_md4.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
@Entity
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Integer companyId;
    @Column(name = "ten_cong_ty")
    @NotEmpty
    private String tenCongTy;
    @Column(name = "linh_vuc_kinh_doanh")
    @NotEmpty
    private String lin0hVucKinhDoanh;
    @Column(name = "so_dien_thoai")
    @NotEmpty
    private String soDienThoai;
    @Email
    private String email;
    @Column(name = "dia_chi")
    @NotEmpty
    private  String diaChi;
    @OneToMany(mappedBy = "companyA", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Project> projects;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getLinhVucKinhDoanh() {
        return linhVucKinhDoanh;
    }

    public void setLinhVucKinhDoanh(String linhVucKinhDoanh) {
        this.linhVucKinhDoanh = linhVucKinhDoanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
