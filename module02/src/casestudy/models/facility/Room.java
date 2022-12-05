package casestudy.models.facility;


public class Room extends Facility {
    private String freeServiceIncluded;
    //dịch vụ miễn phí đi kèm

    public Room() {

    }

    public Room(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public Room(String serviceName, double usableArea, double rentalCost, int maxCapacity,
                String rentalType, String serviceCode, String freeServiceIncluded) {
        super(serviceName, usableArea, rentalCost, maxCapacity, rentalType, serviceCode);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serviceName='" + getServiceName() + '\'' +
                "usableArea='" + getUsableArea() + '\'' +
                "rentalCost='" + getRentalCost() + '\'' +
                "maxCapacity='" + getMaxCapacity() + '\'' +
                "rentalType='" + getRentalType() + '\'' +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                ", ServiceCode='" + getServiceCode() + '\'' +
                '}';
    }
    public String getInfoRoomToCSV() {
        return getServiceName() + "," + getUsableArea() + "," + getRentalCost() + "," + getMaxCapacity() + "," +
                getRentalType() + "," + getServiceCode() + "," +getFreeServiceIncluded();
    }
}
