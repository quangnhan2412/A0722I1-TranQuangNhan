package casestudy.service;

import casestudy.models.person.Employee;

import java.util.List;

public interface EmployeeService extends Service {
    List findAll();
    void addNewEmployee();
    void updateEmployee() ;
    void deleteEmployee() ;
    void searchEmployee() ;
    Employee inputEmployeeInfo() ;
    void sortIDEmployee() ;

}
