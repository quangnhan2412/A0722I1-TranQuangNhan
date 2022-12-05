package casestudy.ultils;

import java.util.Scanner;

public class RegexFacility {
    private static final String REGEX_MDV_VILLA = "^SVVL-\\d{4}$";
    private static final String REGEX_MDV_HOUSE = "^SVHO-\\d{4}$";
    private static final String REGEX_MDV_ROOM = "^SVRO-\\d{4}$";
    private static final String REGEX_NAME_SERVICE = "([A-Z])\\w+";
    private static final String REGEX_RENTAL_TYPE = "([a-z])\\w+";
    private static final String REGEX_ROOM_STANDARD_HOUSE = "(Standard|Superior|Deluxe|Suite|Connecting room)";
    private static final String REGEX_FREE_SERVICE_CLUED = "([a-z])\\w+";
    static Scanner scanner = new Scanner(System.in);

    public static String inputServiceCodeHouse() {
        System.out.println("Enter Service Code House :");
        String codeVilla = scanner.nextLine();
        while (!codeVilla.matches(REGEX_MDV_HOUSE)) {
            try {
                System.out.println("You input bad format, please please get back !(VD : SVHO-****)");
                codeVilla = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("\"You input bad format, please please get back !(VD : SVHO-****)\"");
            }
        }
        return codeVilla;
    }


    public static String inputServiceCodeRoom() {
        System.out.println("Enter Service Code Room :");
        String codeVilla = scanner.nextLine();
        while (!codeVilla.matches(REGEX_MDV_ROOM)) {
            System.out.println("You input bad format, please please get back ! (VD : SVRO-****)");
            codeVilla = scanner.nextLine();
        }
        return codeVilla;
    }

    public static String inputServiceCodeVilla() {
        System.out.println("Enter Service Code Villa: ");
        String codeVilla = scanner.nextLine();
        while (!codeVilla.matches(REGEX_MDV_VILLA)) {
            System.out.println("You input bad format, please please get back ! (VD : SVVL-****)");
            codeVilla = scanner.nextLine();
        }
        return codeVilla;
    }

    public static String inputServiceName() {
        System.out.println("Enter Service Name: ");
        String nameService = scanner.nextLine();
        while (!nameService.matches(REGEX_NAME_SERVICE)) {
            System.out.println("You input bad format, please please get back !");
            nameService = scanner.nextLine();
        }
        return nameService;
    }

    public static Double inputUsableArea() {
        double usableArea;
        do {
            try {
                System.out.println("Enter usable Area :");
                usableArea = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 30 ! ");
                usableArea = -1;
            }
        } while (usableArea < 30);
        return usableArea;

    }

    public static Double inputPoolArea() {
        double poolArea;
        do {
            try {
                System.out.println("Enter pool Area :");
                poolArea = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter pool Area ! ");
                poolArea = -1;
            }
        } while (poolArea <= 30);
        return poolArea;
    }

    public static Double inputRentalCost() {
        double rentalCost;
        do {
            try {
                System.out.println("Enter rental cost :");
                rentalCost = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 0 !");
                rentalCost = -1.0;
            }
        } while (rentalCost <= 0.0);
        return rentalCost;
    }

    public static Integer inputMaxCapacity() {
        int maxCapacity;
        do {
            try {
                System.out.println("Enter max Capacity :");
                maxCapacity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 0 !");
                maxCapacity = -1;
            }
        } while (maxCapacity < 1 || maxCapacity > 20);
        return maxCapacity;
    }

    public static String inputRentalType() {
        System.out.println("Enter Rental Type: ");
        String rentalType = scanner.nextLine();
        while (!rentalType.matches(REGEX_RENTAL_TYPE)) {
            System.out.println("You input bad format, please please get back !(Thue trong bao lau ?)");
            rentalType = scanner.nextLine();
        }
        return rentalType;
    }

    public static String inputRoomStandardHouse() {
        System.out.println("Enter Room Standard House: ");
        String roomStandardHouse = scanner.nextLine();
        while (!roomStandardHouse.matches(REGEX_ROOM_STANDARD_HOUSE)) {
            System.out.println("You input bad format, please please get back ! ");
            System.out.println("choose Standard|Superior|Deluxe|Suite|Connecting room");
            roomStandardHouse = scanner.nextLine();
        }
        return roomStandardHouse;
    }

    public static Integer inputFloor() {
        int floors;
        do {
            try {
                System.out.println("Enter floors ; ");
                floors = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter floors");
                floors = -1;
            }
        } while (floors <= 0);
        return floors;
    }

    public static String inputFreeServiceIncluded() {
        System.out.println("Enter Free Service Included: ");
        String freeServiceIncluded = scanner.nextLine();
        while (!freeServiceIncluded.matches(REGEX_FREE_SERVICE_CLUED)) {
            System.out.println("You input bad format, please please get back !");
            freeServiceIncluded = scanner.nextLine();
        }
        return freeServiceIncluded;
    }

}
