package casestudy.models.facility;

public abstract class Facility {
    private String serviceName;
    //Tên Dịch Vụ
    private double usableArea;
    // Diện tích sử dụng
    private double rentalCost;
    // Chi phí thuê
    private int maxCapacity;
    //Số lượng người tối đa
    private String rentalType;
    //Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ.)
    private String ServiceCode;
    //Mã dịch vụ
    public Facility() {
    }

    public Facility(String serviceName, double usableArea, double rentalCost, int maxCapacity, String rentalType, String serviceCode) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxCapacity = maxCapacity;
        this.rentalType = rentalType;
        this.ServiceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return ServiceCode;
    }

    public void setServiceCode(String serviceCode) {
        ServiceCode = serviceCode;
    }

}
