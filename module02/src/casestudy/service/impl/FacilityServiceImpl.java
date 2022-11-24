package casestudy.service.impl;

import casestudy.models.facility.Facility;
import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;
import casestudy.service.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        facilityMap.put(new Villa("Villa1", 90.2, 100.2, 123,
                "B", "A", 20, 20), 7);
        facilityMap.put(new Villa("Villa2", 98.2, 180.6, 163,
                "C", "D", 25, 25), 3);
        facilityMap.put(new House("House", 50, 100, 111,
                "AAA", "BBB", 5), 3);
        facilityMap.put(new House("House2", 60, 120, 131,
                "CCC", "DDD", 7), 3);
        facilityMap.put(new Room("Room", 50, 100, 15, "GGG", "DSAD"), 5);
        facilityMap.put(new Room("Room2", 70, 1210, 35, "JJJ", "ÂD"), 5);

    }

    @Override
    public void displayAll() {

    }

    @Override
    public void addNewFacility() {
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to menu");
        System.out.println("Enter choice");
        int input;
        input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                addNewVilla();
                addNewFacility();
                break;
            case 2:
                addNewHouse();
                addNewFacility();
                break;
            case 3:
                addNewRoom();
                addNewFacility();
                break;
            case 4:
                break;
            default:
                System.out.println("No choice ! ");
                addNewFacility();
                break;
        }

    }

    @Override
    public void displayList() {
        System.out.println("The facility list as below:");
        for (Facility item : facilityMap.keySet()) {
            System.out.println("key: " + item.toString() + "\t value: " + facilityMap.get(item));
        }
    }

    @Override
    public void addNewVilla() {
        System.out.println("Add a new Villa ");
        Villa villa = validateInfoVilla();
        facilityMap.put(villa, 0);
        displayList();
    }

    @Override
    public Villa validateInfoVilla() {
        //input Villa
        System.out.println("Information of Villa !");
        System.out.println();
        System.out.println("Enter Name Service");
        String serviceName = scanner.nextLine();
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

        int maxCapacity;
        do {
            try {
                System.out.println("Enter max Capacity :");
                maxCapacity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 0 !");
                maxCapacity = -1;
            }
        } while (maxCapacity < 0 || maxCapacity > 20);

        System.out.println("Enter rental Type");
        String rentalType = scanner.nextLine();

        System.out.println("Enter room Standard");
        String roomStandard = scanner.nextLine();


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
        return new Villa(serviceName, usableArea, rentalCost, maxCapacity,
                rentalType, roomStandard, poolArea, floors);
    }

    @Override
    public void addNewRoom() {
        System.out.println("Add a new Room");
        Room room = validateInfoRoom();
        facilityMap.put(room, 0);
        displayList();
    }

    @Override
    public Room validateInfoRoom() {
        System.out.println("Information of Room ");
        System.out.println();
        System.out.println("Enter Name Service");
        String serviceName = scanner.nextLine();

        double usableArea;
        do {
            try {
                System.out.println("Enter usable Area : ");
                usableArea = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 30 ! ");
                usableArea = -1;
            }
        } while (usableArea < 30);

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

        int maxCapacity;
        do {
            try {
                System.out.println("Enter max Capacity :");
                maxCapacity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 0 !");
                maxCapacity = -1;
            }
        } while (maxCapacity < 0 || maxCapacity > 20);

        System.out.println("Enter rental Type");
        String rentalType = scanner.nextLine();

        System.out.println("Enter free Service included :");
        String freeServiceIncluded = scanner.nextLine();
        return new Room(serviceName, usableArea, rentalCost, maxCapacity, rentalType,
                freeServiceIncluded);
    }

    @Override
    public void addNewHouse() {
        System.out.println("Add a new House");
        House house = validateInfoHouse();
        facilityMap.put(house, 0);
        displayList();
    }

    @Override
    public House validateInfoHouse() {
        System.out.println("Information of Room ");
        System.out.println();
        System.out.println("Enter Name Service");
        String serviceName = scanner.nextLine();

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

        int maxCapacity;
        do {
            try {
                System.out.println("Enter max Capacity :");
                maxCapacity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pleas enter a number more than 0 !");
                maxCapacity = -1;
            }
        } while (maxCapacity < 0 || maxCapacity > 20);

        System.out.println("Enter rental Type");
        String rentalType = scanner.nextLine();

        System.out.println("Enter room Standard");
        String roomStandard = scanner.nextLine();
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
        return new House(serviceName, usableArea, rentalCost, maxCapacity, rentalType, roomStandard, floors);
    }

    @Override
    public void displayListUsed() {
        System.out.println("Display list facility maintenance (used to >=5 : ");
        for (Map.Entry<Facility, Integer> item : facilityMap.entrySet()
        ) {
            if (item.getValue() >= 5) {
                System.out.println(item.getKey() + "  " + item.getValue());
            }
        }
    }

}
