package casestudy.service.impl;

import casestudy.models.facility.Facility;
import casestudy.models.facility.House;
import casestudy.models.facility.Room;
import casestudy.models.facility.Villa;
import casestudy.service.FacilityService;
import casestudy.ultils.RegexFacility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static casestudy.ultils.ReadAndWriteToCSVFacility.*;


public class FacilityServiceImpl implements FacilityService {
//    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static final String PATH_HOUSE = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\casestudy\\data\\house.csv";
    public static final String PATH_VILLA = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\casestudy\\data\\villa.csv";
    public static final String PATH_ROOM = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\casestudy\\data\\room.csv";
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
        Map<Facility, Integer> facilityHouse = readHouseToCSV(PATH_HOUSE);
        Map<Facility, Integer> facilityVilla = readVillaToCSV(PATH_VILLA);
        Map<Facility, Integer> facilityRoom = readRoomToCSV(PATH_ROOM);
        System.out.println("The facility list as below:");
        if (facilityHouse != null) {
            System.out.println("Data House");
            for (Facility item : facilityHouse.keySet()) {
                System.out.println("key: " + item.toString() + "\t value: " + facilityHouse.get(item));
            }
        }
        if (facilityVilla != null) {
            System.out.println("Data Villa");
            for (Facility item : facilityVilla.keySet()) {
                System.out.println("key: " + item.toString() + "\t value: " + facilityVilla.get(item));
            }
        }
        if (facilityRoom != null) {
            System.out.println("Data Room");
            for (Facility item : facilityRoom.keySet()) {
                System.out.println("key: " + item.toString() + "\t value: " + facilityRoom.get(item));
            }
        }
    }

    @Override
    public void addNewVilla() {
        LinkedHashMap<Facility, Integer> facilityVilla = readVillaToCSV(PATH_VILLA);
        System.out.println("Add a new Villa ");
        Villa villa = validateInfoVilla();
        facilityVilla.put(villa, 0);
        writeMapVillaTOCSV(facilityVilla,PATH_VILLA,false);
        displayList();
    }

    @Override
    public Villa validateInfoVilla() {
        //input Villa
        String serviceName = RegexFacility.inputServiceName();
        double usableArea = RegexFacility.inputUsableArea();
        double rentalCost = RegexFacility.inputRentalCost();
        int maxCapacity = RegexFacility.inputMaxCapacity();
        String rentalType = RegexFacility.inputRentalType();
        String serviceCode = RegexFacility.inputServiceCodeVilla();
        String roomStandard = RegexFacility.inputRoomStandardHouse();
        double poolArea = RegexFacility.inputPoolArea();
        int floors = RegexFacility.inputFloor();
        return new Villa(serviceName, usableArea, rentalCost, maxCapacity,
                rentalType, serviceCode, roomStandard, poolArea, floors);

    }

    @Override
    public void addNewRoom() {
        LinkedHashMap<Facility, Integer> facilityRoom = readRoomToCSV(PATH_ROOM);
        System.out.println("Add a new Room");
        Room room = validateInfoRoom();
        facilityRoom.put(room, 0);
        writeMapRoomTOCSV(facilityRoom,PATH_ROOM,false);
        displayList();
    }

    @Override
    public Room validateInfoRoom() {
        String serviceName = RegexFacility.inputServiceName();
        double usableArea = RegexFacility.inputUsableArea();
        double rentalCost = RegexFacility.inputRentalCost();
        int maxCapacity = RegexFacility.inputMaxCapacity();
        String rentalType = RegexFacility.inputRentalType();
        String serviceCode = RegexFacility.inputServiceCodeRoom();
        String freeServiceIncluded = RegexFacility.inputFreeServiceIncluded();
        return new Room(serviceName, usableArea, rentalCost, maxCapacity, rentalType, serviceCode, freeServiceIncluded);
    }

    @Override
    public void addNewHouse() {
        LinkedHashMap<Facility, Integer> facilityRoom = readHouseToCSV(PATH_HOUSE);
        System.out.println("Add a new House");
        House house = validateInfoHouse();
        facilityRoom.put(house, 0);
        writeMapHouseTOCSV(facilityRoom, PATH_HOUSE, false);
        displayList();
    }

    @Override
    public House validateInfoHouse() {
        String serviceName = RegexFacility.inputServiceName();
        double usableArea = RegexFacility.inputUsableArea();
        double rentalCost = RegexFacility.inputRentalCost();
        int maxCapacity = RegexFacility.inputMaxCapacity();
        String rentalType = RegexFacility.inputRentalType();
        String serviceCode = RegexFacility.inputServiceCodeHouse();
        String roomStandard = RegexFacility.inputRoomStandardHouse();
        int floors = RegexFacility.inputFloor();

        return new House(serviceName, usableArea, rentalCost, maxCapacity, rentalType, serviceCode, roomStandard, floors);
    }

    @Override
    public void displayListUsed() {
        Map<Facility, Integer> facilityHouse = readHouseToCSV(PATH_HOUSE);
        Map<Facility, Integer> facilityVilla = readVillaToCSV(PATH_VILLA);
        Map<Facility, Integer> facilityRoom = readRoomToCSV(PATH_ROOM);
        System.out.println("Display list facility maintenance (used to >=5) : ");
        for (Map.Entry<Facility, Integer> item : facilityHouse.entrySet()) {
            if (item.getValue() >= 5) {
                System.out.println(item.getKey() + "  " + item.getValue());
            }
        }
        for (Map.Entry<Facility, Integer> item : facilityVilla.entrySet()) {
            if (item.getValue() >= 5) {
                System.out.println(item.getKey() + "  " + item.getValue());
            }
        }
        for (Map.Entry<Facility, Integer> item : facilityRoom.entrySet()) {
            if (item.getValue() >= 5) {
                System.out.println(item.getKey() + "  " + item.getValue());
            }
        }
    }

}
