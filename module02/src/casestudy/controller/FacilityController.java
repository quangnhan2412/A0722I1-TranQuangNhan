package casestudy.controller;

import casestudy.service.impl.FacilityServiceImpl;
import casestudy.ultils.RegexMenu;

import java.util.Scanner;

import static casestudy.controller.FuramaController.displayMainMenu;

public class FacilityController {
    static int choice = -1;
    static Scanner input = new Scanner(System.in);
    static void FacilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        System.out.println("1\tDisplay list facility");
        System.out.println("2\tAdd new facility");
        System.out.println("3\tDisplay list facility maintenance");
        System.out.println("4\tReturn main menu");
        choice = RegexMenu.inputChoiceMenu();;
        switch (choice) {
            case 1:
                facilityService.displayList();
                FacilityManagement();
                break;
            case 2:
                facilityService.addNewFacility();
                FacilityManagement();
                break;
            case 3:
                facilityService.displayListUsed();
                FacilityManagement();
                break;
            case 4:
                displayMainMenu();
                FacilityManagement();
                break;
            default:
                System.out.println("No choice!");
                FacilityManagement();
        }
    }
}
