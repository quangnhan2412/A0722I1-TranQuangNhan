package module2.model;

import module2.model.TaiKhoanNganHang;

import java.time.LocalDate;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private String soTienGuiTietKiem;
    private LocalDate ngayGuiTietKiem;
    private String laiSuat;
    private int kiHan;

    public TaiKhoanTietKiem(String soTienGuiTietKiem, LocalDate ngayGuiTietKiem, String laiSuat, int kiHan) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public TaiKhoanTietKiem(String idTK, String maTK, String fullNameTK, LocalDate ngayTaoTK,
                            String soTienGuiTietKiem, LocalDate ngayGuiTietKiem, String laiSuat, int kiHan) {
        super(idTK, maTK, fullNameTK, ngayTaoTK);
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public String getSoTienGuiTietKiem() {
        return soTienGuiTietKiem;
    }

    public void setSoTienGuiTietKiem(String soTienGuiTietKiem) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
    }

    public LocalDate getNgayGuiTietKiem() {
        return ngayGuiTietKiem;
    }

    public void setNgayGuiTietKiem(LocalDate ngayGuiTietKiem) {
        this.ngayGuiTietKiem = ngayGuiTietKiem;
    }

    public String getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(String laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKiHan() {
        return kiHan;
    }

    public void setKiHan(int kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" +
                "idTK='" + getIdTK() + '\'' +
                ", maTK='" + getMaTK() + '\'' +
                ", fullNameTK='" + getFullNameTK() + '\'' +
                ", ngayTaoTK=" + getNgayTaoTK() +
                "soTienGuiTietKiem='" + soTienGuiTietKiem + '\'' +
                ", ngayGuiTietKiem=" + ngayGuiTietKiem +
                ", laiSuat='" + laiSuat + '\'' +
                ", kiHan=" + kiHan +
                '}';
    }

    @Override
    public String getInfo() {
        return getIdTK() + "," + getMaTK() + "," + getFullNameTK() + "," + getNgayTaoTK() + "," +
                getSoTienGuiTietKiem() + "," + getSoTienGuiTietKiem() + "," + getLaiSuat() + "," + getKiHan();
    }
}
