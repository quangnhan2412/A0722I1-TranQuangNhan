package casestudy;

public class House extends Facility {
    private int tieuChuanPhong;
    private int soTang;

    public House() {
        this.tieuChuanPhong = 3;
        this.soTang = 5;
    }

    public House(int tieuChuanPhong, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public int getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(int tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "House{" +
                "tieuChuanPhong=" + tieuChuanPhong +
                ", soTang=" + soTang +
                '}';
    }

    @Override
    public String tenDichVu() {
        return null;
    }

    @Override
    public double dienTichSuDung() {
        return 0;
    }

    @Override
    public double chiPhiThue() {
        return 0;
    }

    @Override
    public int soLuongNguoiToiDa() {
        return 0;
    }

    @Override
    public long Date() {
        return 0;
    }
}
