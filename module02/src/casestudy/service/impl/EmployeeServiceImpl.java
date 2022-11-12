package casestudy.service.impl;

import casestudy.models.Employee;
import casestudy.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static int size = 0;
    Scanner scanner = new Scanner(System.in);


    static {
        employeeList.add(new Employee("Tran Quang Nhan", "24-12-2000", true,
                "201821774", "0777368452", "tranquangnhan24122000@gmail.com", "NV001",
                "Intern", 1, "normal"));
        employeeList.add(new Employee("Tran Quang Nhan2", ("24-12-2000"), false,
                "201821774", "0777368452", "tranquangnhan24122000@gmail.com", "NV002",
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
        employeeList.add(inputEmployeeInfo());
        disPlayAll();
    }


    @Override
    public List findAll() {
        return employeeList;
    }

    @Override
    public void updateEmployee(String employeeID) {
//        boolean check = false;
        for (int i = 0; i < employeeList.size(); i++) {
          if (employeeList.get(i).getEmployeeID().equals(employeeID)) {
//                check = true;
            Employee NewEmployee = inputEmployeeInfo();
            employeeList.set(i,NewEmployee);
            break;
        } else {
            System.out.println("Not found");
            break;
        }
        }
    }


    @Override
    public Employee inputEmployeeInfo() {
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
        double newSalary = Double.parseDouble(scanner.nextLine());
        //nhập number rồi nhập String là phải có type.parseDouble
        System.out.println("Enter Level ");
        String newLevel = scanner.nextLine();

        return new Employee(fullName, birthDay, newGender, newIDCard, newNumberPhone,
                newEmail, newEmployeeID, newPosition, newSalary, newLevel);
    }
}
