package casestudy.models.booking;

import java.time.LocalDate;

public class Booking {
    private String bookingID;
    //mã booking
    private LocalDate checkInDay;
    //Ngày bắt đầu
    private LocalDate checkOutDay;
    //Ngày kết thúc;
    private String customerID;
    //Mã khách hàng
    private String serviceName;
    //tên dịch vụ
    private String typeOfService;
    // loại dịch vụ.

    public Booking(){

    }

    public Booking(String bookingID, LocalDate checkInDay,
                   LocalDate checkOutDay, String customerID, String serviceName, String typeOfService) {
        this.bookingID = bookingID;
        this.checkInDay = checkInDay;
        this.checkOutDay = checkOutDay;
        this.customerID = customerID;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(LocalDate checkInDay) {
        this.checkInDay = checkInDay;
    }

    public LocalDate getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(LocalDate checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", checkInDay=" + checkInDay +
                ", checkOutDay=" + checkOutDay +
                ", customerID='" + customerID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }
}
