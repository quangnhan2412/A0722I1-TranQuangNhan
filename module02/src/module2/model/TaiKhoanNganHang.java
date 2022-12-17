package module2.model;

import java.time.LocalDate;

public abstract class TaiKhoanNganHang {
    public abstract String getInfo();
    private String idTK;
    private String maTK;
    private String fullNameTK;
    private LocalDate ngayTaoTK ;

    public TaiKhoanNganHang() {
    }

    public TaiKhoanNganHang(String idTK, String maTK, String fullNameTK, LocalDate ngayTaoTK) {
        this.idTK = idTK;
        this.maTK = maTK;
        this.fullNameTK = fullNameTK;
        this.ngayTaoTK = ngayTaoTK;
    }

    public String getIdTK() {
        return idTK;
    }

    public void setIdTK(String idTK) {
        this.idTK = idTK;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getFullNameTK() {
        return fullNameTK;
    }

    public void setFullNameTK(String fullNameTK) {
        this.fullNameTK = fullNameTK;
    }

    public LocalDate getNgayTaoTK() {
        return ngayTaoTK;
    }

    public void setNgayTaoTK(LocalDate ngayTaoTK) {
        this.ngayTaoTK = ngayTaoTK;
    }

    @Override
    public String toString() {
        return "TaiKhoanNganHang{" +
                "idTK='" + idTK + '\'' +
                ", maTK='" + maTK + '\'' +
                ", fullNameTK='" + fullNameTK + '\'' +
                ", ngayTaoTK=" + ngayTaoTK +
                '}';
    }
}
