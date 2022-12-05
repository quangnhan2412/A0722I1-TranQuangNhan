package casestudy.controller;

import casestudy.service.impl.CustomerServiceImpl;
import casestudy.ultils.RegexMenu;

import java.util.Scanner;

import static casestudy.controller.FuramaController.displayMainMenu;

public class CustomerController {
    static int choice = -1;
    static void CustomerManagement()  {
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
        System.out.println("1.\tDisplay list customers");
        System.out.println("2.\tAdd new customer");
        System.out.println("3.\tEdit customer");
        System.out.println("4.\tReturn main menu");
        choice = RegexMenu.inputChoiceMenu();;
        switch (choice) {
            case 1:
                customerServiceImpl.displayAll();
                CustomerManagement();
                break;
            case 2:
                customerServiceImpl.addCustomer();
                CustomerManagement();
                break;
            case 3:
                customerServiceImpl.displayAll();
                System.out.println("Enter id Customer : ");
                Scanner scanner =new Scanner(System.in);
                String customerID = scanner.nextLine();
                customerServiceImpl.updateCustomer(customerID);
                customerServiceImpl.displayAll();
                CustomerManagement();
                break;
            case 4:
                displayMainMenu();
                CustomerManagement();
                break;
            default:
                System.out.println("No choice!");
                CustomerManagement();
        }
    }
}
