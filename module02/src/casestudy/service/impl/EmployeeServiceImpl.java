package casestudy.service.impl;

import casestudy.models.person.Employee;
import casestudy.service.EmployeeService;
import casestudy.ultils.EmployeeSortID;
import casestudy.ultils.RegexMenu;
import casestudy.ultils.RegexPerson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static casestudy.controller.EmployeeController.EmployeeManagement;
import static casestudy.ultils.ReadAndWriteToCSV.readListEmployeeTOCSV;
import static casestudy.ultils.ReadAndWriteToCSV.writeListEmployeeTOCSV;
import static casestudy.ultils.RegexPerson.inputNewEmployeeID;

public class EmployeeServiceImpl implements EmployeeService {
    public static final String PATH_EMPLOYEE = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\casestudy\\data\\employee.csv";
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayAll() {
        List<Employee> employeeArrayList = readListEmployeeTOCSV(PATH_EMPLOYEE);
        if (employeeArrayList != null) {
            for (int i = 0; i < employeeArrayList.size(); i++) {
                System.out.println((i + 1) + ">" + employeeArrayList.get(i));
            }
        }
    }

    @Override
    public void addNewEmployee() {
        List<Employee> employeeArrayList = readListEmployeeTOCSV(PATH_EMPLOYEE);
        System.out.println("You want update ? \n" +
                "1.Yes\n" +
                "2.No");
        int check = RegexMenu.inputChoiceMenu();
        if (check == 1) {
            employeeArrayList.add(inputEmployeeInfo());
            writeListEmployeeTOCSV(employeeArrayList, PATH_EMPLOYEE, false);
            displayAll();
        } else {
            EmployeeManagement();
        }
    }

    @Override
    public List findAll() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        return employeeList;
    }

    @Override
    public void updateEmployee() {
        //Update index
        List<Employee> employeeArrayList = readListEmployeeTOCSV(PATH_EMPLOYEE);
        displayAll();

        System.out.println("You want update ? \n" +
                "1.Yes\n" +
                "2.No");
        int check = RegexMenu.inputChoiceMenu();
        switch (check) {
            case 1:
                System.out.println("Enter number Employee to update : ");
                int chooseUpdate = RegexMenu.inputChoiceMenu();
                int chooseIndex = chooseUpdate - 1;
                boolean isExits = false;
                Employee newEmployee = inputEmployeeInfo();
                for (int j = 0; j < employeeArrayList.size(); j++) {
                    if (chooseIndex == j) {
                        employeeArrayList.set(chooseIndex, newEmployee);
                        writeListEmployeeTOCSV(employeeArrayList, PATH_EMPLOYEE, false);
                        isExits = true;
                        break;
                    }
                }
                if (!isExits) {
                    System.out.println("Not Found!!!");
                }
                break;
            case 2:
                EmployeeManagement();
                break;
            default:
                System.out.println("No Choice!!!");
                EmployeeManagement();
        }
    }

    @Override
    public void deleteEmployee() {
        List<Employee> employeeArrayList = readListEmployeeTOCSV(PATH_EMPLOYEE);
        displayAll();
        System.out.println("You want delete ? \n" +
                "1.Yes\n" +
                "2.No");
        int check = RegexMenu.inputChoiceMenu();
        switch (check) {
            case 1:
                boolean isExits = false;
                System.out.println("Enter id Employee you want to delete?");
                String delId = scanner.nextLine();
                for (int i = 0; i < employeeArrayList.size(); i++) {
                    if (employeeArrayList.get(i).getEmployeeID().equals(delId)) {
                        employeeArrayList.remove(i);
                        writeListEmployeeTOCSV(employeeArrayList, PATH_EMPLOYEE, false);
                        isExits = true;
                        break;
                    }
                }
                if (!isExits) {
                    System.out.println("Not found!!!");
                    deleteEmployee();
                }
                break;
            case 2:
                EmployeeManagement();
                break;
            default:
                System.out.println("No Choice!!!");
                EmployeeManagement();
        }
    }

    @Override
    public void searchEmployee() {
        List<Employee> employeeArrayList = readListEmployeeTOCSV(PATH_EMPLOYEE);
        displayAll();
        boolean isExits = false;
        System.out.println("Enter ID Employee Search :");
        String searchID = inputNewEmployeeID();
        for (Employee employee : employeeArrayList) {
            if (employee.getEmployeeID().equals(searchID)) {
//                System.out.println("fullName='" + employee.getFullName() + '\'' +
//                        ", dateOfBirth=" + employee.getDayOfBirth() +
//                        ", gender=" + employee.isGender() +
//                        ", identityCard='" + employee.getIdentityCard() + '\'' +
//                        ", phoneNumber='" + employee.getPhoneNumber() + '\'' +
//                        ", email='" + employee.getEmail() + '\'' +
//                        ", employeeID='" + employee.getEmployeeID() + '\'' +
//                        ", level='" + employee.getLevel() + '\'' +
//                        ", position='" + employee.getPosition() + '\'' +
//                        ", salary=" + employee.getSalary());
                System.out.println(employee);
                isExits = true;
                break;
            }
        }
        if (!isExits) {
            System.out.println("Not Found!!!");
        }
    }

    @Override
    public Employee inputEmployeeInfo() {
        String fullName = RegexPerson.inputFullName();
        LocalDate birthDay = RegexPerson.inputBirthday();
        boolean newGender = RegexPerson.inputGender();
        String newIDCard = RegexPerson.inputNewIDCard();
        String newNumberPhone = RegexPerson.inputNewNumberPhone();
        String newEmail = RegexPerson.inputNewEmail();
        String newEmployeeID = inputNewEmployeeID();
        String newPosition = RegexPerson.inputNewPosition();
        double newSalary = RegexPerson.inputNewSalary();
        String newLevel = RegexPerson.inputNewLevel();

        return new Employee(fullName, birthDay, newGender, newIDCard, newNumberPhone,
                newEmail, newEmployeeID, newPosition, newSalary, newLevel);

    }

    @Override
    public void sortIDEmployee() {
        displayAll();
        System.out.println("=========================================================================================");
        List<Employee> employeeArrayList = readListEmployeeTOCSV(PATH_EMPLOYEE);
        Collections.sort(employeeArrayList,new EmployeeSortID());
        writeListEmployeeTOCSV(employeeArrayList, PATH_EMPLOYEE, false);
        displayAll();
    }
}