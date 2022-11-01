package casestudy;

public class Room extends Facility {
    private String dichVuFree;

    public Room() {
        this.dichVuFree = "Miễn phí nước uống";
    }

    public Room(String dichVuFree) {
        this.dichVuFree = dichVuFree;
    }

    public String getDichVuFree() {
        return dichVuFree;
    }

    public void setDichVuFree(String dichVuFree) {
        this.dichVuFree = dichVuFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "dichVuFree='" + dichVuFree + '\'' +
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
