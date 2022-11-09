package casestudy.service;

import casestudy.models.Employee;

import java.util.List;

public interface EmployeeService extends Service {
    List findAll();
    void addNewEmployee();
    void updateEmployee(String employeeID);
    Employee inputEmployeeInfo();

}
