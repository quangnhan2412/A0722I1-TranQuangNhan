package casestudy.models.facility;

public class House extends Facility {
    private String roomStandard;
    //Tiêu chuẩn phòng
    private int floors;

    //Số tầng
    public House() {

    }

    public House(String roomStandard, int floors) {
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public House(String serviceName, double usableArea, double rentalCost, int maxCapacity,
                 String rentalType, String serviceCode, String roomStandard, int floors) {
        super(serviceName, usableArea, rentalCost, maxCapacity, rentalType, serviceCode);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "House{" +
                "serviceName='" + getServiceName() + '\'' +
                "usableArea='" + getUsableArea() + '\'' +
                "rentalCost='" + getRentalCost() + '\'' +
                "maxCapacity='" + getMaxCapacity() + '\'' +
                "rentalType='" + getRentalType() + '\'' +
                "roomStandard='" + roomStandard + '\'' +
                ", floors=" + floors +
                ", serviceCode=" + getServiceCode() +
                '}';
    }

    public String getInfoHouseToCSV() {
        return getServiceName() + "," + getUsableArea() + "," + getRentalCost() + "," + getMaxCapacity() + "," +
                getRentalType() + "," + getServiceCode() + "," + getRoomStandard() + "," + getFloors();

    }
}
