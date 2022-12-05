package casestudy.models.person;

import java.time.LocalDate;

public class Customer extends Person {
    private String customerID;
    private String customerType;
    private String address;

    public Customer() {

    }

    public Customer(String customerID, String customerType, String address) {
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String fullName, LocalDate dayOfBirth, boolean gender,
                    String identityCard, String phoneNumber, String email, String customerID, String customerType, String address) {
        super(fullName, dayOfBirth, gender, identityCard, phoneNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        if (isGender()) {
            return "Customer{" +
                    "fullName='" + getFullName() + '\'' +
                    ", dateOfBirth=" + getDayOfBirth() +
                    ", gender=" + "male" +
                    ", identityCard='" + getIdentityCard() + '\'' +
                    ", phoneNumber='" + getPhoneNumber() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", customerID='" + customerID + '\'' +
                    ", customerType='" + customerType + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        } else {
            return "Customer{" +
                    "fullName='" + getFullName() + '\'' +
                    ", dateOfBirth=" + getDayOfBirth() +
                    ", gender=" + "female" +
                    ", identityCard='" + getIdentityCard() + '\'' +
                    ", phoneNumber='" + getPhoneNumber() + '\'' +
                    ", email='" + getEmail() + '\'' +
                    ", customerID='" + customerID + '\'' +
                    ", customerType='" + customerType + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public String getInfoCustomerToCSV() {
        return getFullName() + "," + getDayOfBirth() + "," + isGender() + "," + getIdentityCard() + "," +
                getPhoneNumber() + "," + getEmail() + "," + getCustomerID() + "," + getCustomerType() + "," + getAddress();
    }
}
