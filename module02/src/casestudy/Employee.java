package casestudy;

public class Employee extends Person  {
    private String trinhDo;
    private String viTri;
    private double luong;
    private int maKH;


    public Employee() {
    }

    public Employee(String trinhDo, String viTri, double luong, int maKH) {
        this.trinhDo = trinhDo;
        this.viTri = viTri;
        this.luong = luong;
        this.maKH = maKH;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "trinhDo='" + trinhDo + '\'' +
                ", viTri='" + viTri + '\'' +
                ", luong=" + luong +
                ", maKH=" + maKH +
                '}';
    }

    @Override
    public String name() {
        return this.name();
    }

    @Override
    public boolean gioiTinh() {
        return this.gioiTinh();
    }

    @Override
    public String soDT() {
        return this.soDT();
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
