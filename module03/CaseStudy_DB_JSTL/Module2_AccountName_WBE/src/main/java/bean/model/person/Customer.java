package bean.model.person;


import java.util.Date;

public class Customer extends Person{
private  int customerId;
private  int customerTypeId;
private  boolean gender;

    public Customer(int customerId, int customerTypeId, boolean gender) {
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        this.gender = gender;
    }

    public Customer(String fullName, String identityCard, Date dayOfBirth, String phoneNumber, String email, String address, int customerId, int customerTypeId, boolean gender) {
        super(fullName, identityCard, dayOfBirth, phoneNumber, email, address);
        this.customerId = customerId;
        this.customerTypeId = customerTypeId;
        this.gender = gender;
    }    public Customer(String fullName, String identityCard, Date dayOfBirth, String phoneNumber, String email, String address, int customerTypeId, boolean gender) {
        super(fullName, identityCard, dayOfBirth, phoneNumber, email, address);
        this.customerTypeId = customerTypeId;
        this.gender = gender;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
