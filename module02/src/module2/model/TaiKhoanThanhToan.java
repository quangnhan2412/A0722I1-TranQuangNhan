package module2.model;

import module2.model.TaiKhoanNganHang;

import java.time.LocalDate;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private String soThe;
    private String soTienTrongTK;


    public TaiKhoanThanhToan(String soThe, String soTienTrongTK) {
        this.soThe = soThe;
        this.soTienTrongTK = soTienTrongTK;
    }

    public TaiKhoanThanhToan(String idTK, String maTK, String fullNameTK, LocalDate ngayTaoTK, String soThe, String soTienTrongTK) {
        super(idTK, maTK, fullNameTK, ngayTaoTK);
        this.soThe = soThe;
        this.soTienTrongTK = soTienTrongTK;
    }

    public String getSoThe() {
        return soThe;
    }

    public void setSoThe(String soThe) {
        this.soThe = soThe;
    }

    public String getSoTienTrongTK() {
        return soTienTrongTK;
    }

    public void setSoTienTrongTK(String soTienTrongTK) {
        this.soTienTrongTK = soTienTrongTK;
    }

    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" +
                "idTK='" + getIdTK() + '\'' +
                ", maTK='" + getMaTK() + '\'' +
                ", fullNameTK='" + getFullNameTK() + '\'' +
                ", ngayTaoTK=" + getNgayTaoTK() +
                "soThe='" + soThe + '\'' +
                ", soTienTrongTK='" + soTienTrongTK + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return getIdTK() + "," + getMaTK() + "," + getFullNameTK() + "," + getNgayTaoTK() + "," + getSoThe() + "," + getSoTienTrongTK();
    }
}
