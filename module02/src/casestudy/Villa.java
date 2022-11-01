package casestudy;

public class Villa extends Facility {
    private int tieuChuanPhong;
    private double dienTichHoBoi;
    private int soTang;


    public Villa() {
        this.tieuChuanPhong = 1;
        this.dienTichHoBoi = 12.0;
        this.soTang = 10;
    }

    public Villa(int tieuChuanPhong, double dienTichHoBoi, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public int getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(int tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "tieuChuanPhong=" + tieuChuanPhong +
                ", dienTichHoBoi=" + dienTichHoBoi +
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
