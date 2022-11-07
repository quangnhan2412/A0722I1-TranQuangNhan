package casestudy.service.impl;

import casestudy.models.Employee;
import casestudy.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static int size = 0;

    static {
        employeeList.add(new Employee("Tran Quang Nhan", "24-12-2000", true,
                "201821774", "0777368452", "tranquangnhan24122000@gmail.com", "NV001",
                "Intern", 1, "normal"));
        employeeList.add(new Employee("Tran Quang Nhan2", ("24-12-2000"), false,
                "201821774", "0777368452", "tranquangnhan24122000@gmail.com", "NV001",
                "Intern", 1, "normal"));
        size = 2;
    }

    @Override
    public void disPlayAll() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }

    @Override
    public void addNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first and last name : ");
        String fullName = scanner.nextLine();
        System.out.println("Enter date of birth : ");
        String birthDay = scanner.nextLine();
        System.out.println("Enter true (male) or incorrect (female) gender : ");
        boolean newGender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter identification card : ");
        String newIDCard = scanner.nextLine();
        System.out.println("Enter number phone : ");
        String newNumberPhone = scanner.nextLine();
        System.out.println("Enter email: ");
        String newEmail = scanner.nextLine();
        System.out.println("Enter employee ID  ");
        String newEmployeeID = scanner.nextLine();
        System.out.println("Enter Position  ");
        String newPosition = scanner.nextLine();
        System.out.println("Enter salary  ");
        double newSalary = scanner.nextDouble();
        System.out.println("Enter Level ");
        String newLevel = scanner.nextLine();

        Employee newEmployee = new Employee(fullName, birthDay, newGender, newIDCard, newNumberPhone,
                newEmail, newEmployeeID, newPosition, newSalary, newLevel);

        employeeList.add(newEmployee);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i));
        }
    }


    @Override
    public List findAll() {
        return employeeList;
    }

    @Override
    public void updateEmployee(String employeeID) {

    }

}
