package casestudy;

public class Customer extends Person {
    private int maNV;
    private String loaiKhach;
    private String diaChi;

    public Customer() {
    }

    public Customer(int maNV, String loaiKhach, String diaChi) {
        this.maNV = maNV;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "maNV=" + maNV +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public boolean gioiTinh() {
        return false;
    }

    @Override
    public String soDT() {
        return null;
    }

    @Override
    public String email() {
        return null;
    }

    @Override
    public String level() {
        return null;
    }
}
