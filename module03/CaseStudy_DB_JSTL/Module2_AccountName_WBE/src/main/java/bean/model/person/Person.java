package bean.model.person;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
private String FullName;
private String identityCard;
private Date dayOfBirth;
private String phoneNumber;
private String email;
private String address;

    public Person() {
    }

    public Person(String fullName, String identityCard, Date dayOfBirth, String phoneNumber, String email, String address) {
        FullName = fullName;
        this.identityCard = identityCard;
        this.dayOfBirth = dayOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FullName='" + FullName + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
