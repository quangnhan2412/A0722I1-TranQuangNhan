package bean.repository.person;

import bean.model.person.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    List<Employee> selectAllEmployee();

    Employee selectEmployee(int idKey);

    List<Employee> selectEmployee(String keyName);

    boolean deleteEmployee(int  id);

    Map<Integer, String> selectAllPosition();

    Map<Integer, String> selectAllEducationDegree();

    Map<Integer, String> selectAllDivision();

    void insertEmployee(Employee employee) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    List<Employee> search(String searchName, double searchSalary, int searchPositionId);

    List<Employee> selectEmployeeByNameSalary(String searchName, double searchSalary);

}
