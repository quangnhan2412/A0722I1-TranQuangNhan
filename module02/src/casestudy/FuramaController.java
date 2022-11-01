package casestudy;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    static int choice = -1;
    static Scanner input = new Scanner(System.in);

    static void displayMainMenu() {
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management ");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                EmployeeManagement();
                break;
            case 2:
                CustomerManagement();
                break;
            case 3:
                FacilityManagement();
                break;
            case 4:
                BookingManagement();
                break;
            case 5:
                PromotionManagement();
                break;
            case 6:
                System.exit(6);
            default:
                System.out.println("No choice!");
                displayMainMenu();
        }
    }

    static void EmployeeManagement() {
        System.out.println("1.\tDisplay list employees");
        System.out.println("2.\tAdd new employee");
        System.out.println("3.\tEdit employee");
        System.out.println("4.\tReturn main menu");
        System.out.println();
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("No choice!");
                EmployeeManagement();
        }
    }

    static void CustomerManagement() {
        System.out.println("1.\tDisplay list customers");
        System.out.println("2.\tAdd new customer");
        System.out.println("3.\tEdit customer");
        System.out.println("4.\tReturn main menu");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("No choice!");
                CustomerManagement();
        }
    }

    static void FacilityManagement() {
        System.out.println("1\tDisplay list facility");
        System.out.println("2\tAdd new facility");
        System.out.println("3\tDisplay list facility maintenance");
        System.out.println("4\tReturn main menu");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("No choice!");
                FacilityManagement();
        }
    }

    static void BookingManagement() {
        System.out.println("1.\tAdd new booking");
        System.out.println("2.\tDisplay list booking");
        System.out.println("3.\tCreate new contracts");
        System.out.println("4.\tDisplay list contracts");
        System.out.println("5.\tEdit contracts");
        System.out.println("6.\tReturn main menu");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                displayMainMenu();
                break;
            default:
                System.out.println("No choice!");
                FacilityManagement();
        }
    }

    static void PromotionManagement() {
        System.out.println("1.\tDisplay list customers use service");
        System.out.println("2.\tDisplay list customers get voucher");
        System.out.println("3.\tReturn main menu");
        choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                System.out.println("No choice!");
                PromotionManagement();
        }
    }
}

