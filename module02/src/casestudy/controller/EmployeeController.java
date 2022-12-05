package casestudy.controller;

import casestudy.service.impl.EmployeeServiceImpl;
import casestudy.ultils.RegexMenu;

import java.util.Collections;

import static casestudy.controller.FuramaController.displayMainMenu;

public class EmployeeController {
    static int choice = -1;

    public static void EmployeeManagement() {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        System.out.println("1.\tDisplay list employees");
        System.out.println("2.\tAdd new employee");
        System.out.println("3.\tEdit employee");
        System.out.println("4.\tReturn main menu");
        System.out.println("5.\tDelete employee");
        System.out.println("6.\tSearch employee");
        System.out.println("7.\tSort ID employee");
        System.out.println();
        choice = RegexMenu.inputChoiceMenu();
        switch (choice) {
            case 1:
                employeeServiceImpl.displayAll();
                EmployeeManagement();
                break;
            case 2:
                employeeServiceImpl.addNewEmployee();
                EmployeeManagement();
                break;
            case 3:
                employeeServiceImpl.updateEmployee();
                EmployeeManagement();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                employeeServiceImpl.deleteEmployee();
                EmployeeManagement();
                break;
            case 6:
                employeeServiceImpl.searchEmployee();
                EmployeeManagement();
                break;
            case 7:
                employeeServiceImpl.sortIDEmployee();
                EmployeeManagement();
                break;
            default:
                System.out.println("No choice!");
                EmployeeManagement();
        }
    }

}
