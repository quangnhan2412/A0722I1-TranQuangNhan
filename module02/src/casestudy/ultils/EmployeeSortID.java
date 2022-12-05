package casestudy.ultils;

import casestudy.models.person.Employee;

import java.util.Comparator;

public class EmployeeSortID implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmployeeID().compareTo(o2.getEmployeeID());
    }
}
