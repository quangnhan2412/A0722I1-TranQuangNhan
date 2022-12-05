package casestudy.models.person;

import java.time.LocalDate;

public class Employee extends Person {
    private String employeeID;
    //id nhân viên
    private String position;
    //Chức vụ
    private double salary;
    //Lương
    private String level;
    //Trình độ

    public Employee() {
    }

    public Employee(String employeeID, String position, double salary, String level) {
        this.employeeID = employeeID;
        this.position = position;
        this.salary = salary;
        this.level = level;
    }
    public Employee(String fullName, LocalDate dayOfBirth, boolean gender, String identityCard,
                    String phoneNumber, String email, String employeeID, String position, double salary, String level) {
        super(fullName, dayOfBirth, gender, identityCard, phoneNumber, email);
        this.employeeID = employeeID;
        this.position = position;
        this.salary = salary;
        this.level = level;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    @Override
    public String toString() {
        if (isGender()) return
                "Employee{" +
                        "fullName='" + getFullName() + '\'' +
                        ", dateOfBirth=" + getDayOfBirth() +
                        ", gender=" + "male" +
                        ", identityCard='" + getIdentityCard() + '\'' +
                        ", phoneNumber='" + getPhoneNumber() + '\'' +
                        ", email='" + getEmail() + '\'' +
                        ", employeeID='" + employeeID + '\'' +
                        ", level='" + level + '\'' +
                        ", position='" + position + '\'' +
                        ", salary=" + salary +
                        '}';
        else {
            return
                    "Employee{" +
                            "fullName='" + getFullName() + '\'' +
                            ", dateOfBirth=" + getDayOfBirth() +
                            ", gender=" + "female" +
                            ", identityCard='" + getIdentityCard() + '\'' +
                            ", phoneNumber='" + getPhoneNumber() + '\'' +
                            ", email='" + getEmail() + '\'' +
                            ", employeeID='" + employeeID + '\'' +
                            ", level='" + level + '\'' +
                            ", position='" + position + '\'' +
                            ", salary=" + salary +
                            '}';
        }
    }

    public String getInfoEmployeeToCSV() {
        return getFullName() + "," + getDayOfBirth() + "," + isGender() + "," + getIdentityCard() + "," +
                getPhoneNumber() + "," + getEmail() + "," + getEmployeeID() + "," + getPosition() + "," + getSalary() + "," + getLevel();
    }
}
