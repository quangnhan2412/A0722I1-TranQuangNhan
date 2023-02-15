package bean.model.person;

import java.time.LocalDate;
import java.util.Date;

public class Employee extends Person {
private int employeeId;
private double salary;
private int positionId;
private int educationDegreeId;
private int divisionId;
private String userName;

    public Employee(int employeeId, double salary, int positionId, int educationDegreeId, int divisionId, String userName) {
        this.employeeId = employeeId;
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.userName = userName;
    }

    public  Employee(int employeeId,String fullName,Date dayOfBirth,String identityCard,double salary ,  String phoneNumber, String email,
                     String address,int positionId, int educationDegreeId,int divisionId,String userName){
        super(fullName, identityCard, dayOfBirth, phoneNumber, email, address);
        this.employeeId = employeeId;
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
        this.userName = userName;
    }
    public  Employee (String fullName, Date dayOfBirth,String identityCard,double salary ,  String phoneNumber, String email,
    String address,int positionId, int educationDegreeId,int divisionId){
        super(fullName, identityCard, dayOfBirth, phoneNumber, email, address);
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }
    public  Employee(int employeeId,String fullName,Date dayOfBirth,String identityCard,double salary ,  String phoneNumber, String email,
                     String address,int positionId, int educationDegreeId,int divisionId ){
        super(fullName, identityCard, dayOfBirth, phoneNumber, email, address);
        this.employeeId = employeeId;
        this.salary = salary;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", salary=" + salary +
                ", positionId=" + positionId +
                ", educationDegreeId=" + educationDegreeId +
                ", divisionId=" + divisionId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
