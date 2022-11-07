package casestudy.service;

import java.util.List;

public interface EmployeeService extends Service {
    List findAll();
    void addNewEmployee();
    void updateEmployee(String employeeID);

}
