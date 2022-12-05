package casestudy.models.facility;

import casestudy.models.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    //Tiêu chuẩn phòng
    private double poolArea;
    //Diện tích hồ bơi
    private int floors;

    //Số tầng
    public Villa() {

    }

    public Villa(String roomStandard, double poolArea, int floors) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Villa(String serviceName, double usableArea, double rentalCost, int maxCapacity,
                 String rentalType, String serviceCode, String roomStandard, double poolArea, int floors) {
        super(serviceName, usableArea, rentalCost, maxCapacity, rentalType, serviceCode);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceName='" + getServiceName() + '\'' +
                "usableArea='" + getUsableArea() + '\'' +
                "rentalCost='" + getRentalCost() + '\'' +
                "maxCapacity='" + getMaxCapacity() + '\'' +
                "rentalType='" + getRentalType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors +
                ", ServiceCode='" + getServiceCode() + '\'' +
                '}';
    }

    public String getInfoVillaToCSV() {
        return getServiceName() + "," + getUsableArea() + "," + getRentalCost() + "," + getMaxCapacity() + "," +
                getRentalType() + "," + getServiceCode() + "," + getRoomStandard() + "," + getPoolArea() + "," + getFloors();
    }
}
