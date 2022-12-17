package module2.service.impl;

import casestudy.ultils.RegexMenu;
import casestudy.validate.AgeException;
import module2.model.TaiKhoanNganHang;
import module2.model.TaiKhoanThanhToan;
import module2.service.TaiKhoanThanhToanService;
import casestudy.ultils.RegexPerson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static casestudy.controller.EmployeeController.EmployeeManagement;
import static module2.ultils.ReadAndWriteFileCSV.readFromFile;
import static module2.ultils.ReadAndWriteFileCSV.writeListTaiKhoanThanhToanTOCSV;
import static casestudy.ultils.RegexPerson.*;

public class TaiKhoanThanhToanServiceImpl implements TaiKhoanThanhToanService {
    public static final String PATH_ACCOUNT = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\module2\\data\\bank_accounts.csv";
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayAll() {
        ArrayList<TaiKhoanNganHang> ArrayList = readFromFile(PATH_ACCOUNT);
        if (ArrayList != null) {
            for (int i = 0; i < ArrayList.size(); i++) {
                System.out.println((i + 1) + ">" + ArrayList.get(i));
            }
        }
    }

    @Override
    public void add() {
        ArrayList<TaiKhoanNganHang> ArrayList = readFromFile(PATH_ACCOUNT);
        System.out.println("You want update ? \n" +
                "1.Yes\n" +
                "2.No");
        int check = RegexMenu.inputChoiceMenu();
        if (check == 1) {
            ArrayList.add(inputInfo());
            writeListTaiKhoanThanhToanTOCSV(ArrayList, PATH_ACCOUNT, false);
            displayAll();
        } else {
            EmployeeManagement();
        }
    }

    @Override
    public void delete() {
        ArrayList<TaiKhoanNganHang> ArrayList = readFromFile(PATH_ACCOUNT);
        System.out.println("You want delete ? \n" +
                "1.Yes\n" +
                "2.No");
        int check = RegexMenu.inputChoiceMenu();
        switch (check) {
            case 1:
                boolean isExits = false;
                System.out.println("Enter id Employee you want to delete?");
                String delId = scanner.nextLine();
                for (int i = 0; i < ArrayList.size(); i++) {
                    if (ArrayList.get(i).getIdTK().equals(delId)) {
                        ArrayList.remove(i);
                        writeListTaiKhoanThanhToanTOCSV(ArrayList, PATH_ACCOUNT, false);
                        isExits = true;
                        break;
                    }
                }
                if (!isExits) {
                    System.out.println("Not found!!!");
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
    public void displayList() {

    }

    @Override
    public void searchList() {
        ArrayList<TaiKhoanNganHang> ArrayList = readFromFile(PATH_ACCOUNT);
        displayAll();
        boolean isExits = false;
        System.out.println("Enter ID  Search :");
        String searchID = scanner.nextLine();
        for (TaiKhoanNganHang taiKhoanNganHang : ArrayList) {
            if (taiKhoanNganHang.getFullNameTK().toLowerCase().contains(searchID.toLowerCase())) {
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
                System.out.println(taiKhoanNganHang);
                isExits = true;
            }
        }
        if (!isExits) {
            System.out.println("Not Found!!!");
        }
    }


    @Override
    public TaiKhoanThanhToan inputInfo() {

        String idTK = inputNewIDCard();
        String maTK = inputNewIDCard();
        String fullNameTK = inputFullName();
        LocalDate ngayTaoTK;
        do {
            try {
                ngayTaoTK = RegexPerson.inputBirthday();
                break;
            } catch (AgeException e) {
                System.out.println("AAA");
            }
        } while (true);
        String soThe = inputNewIDCard();
        String soTienTrongTK = inputNewIDCard();

        return new TaiKhoanThanhToan(idTK, maTK, fullNameTK, ngayTaoTK, soThe, soTienTrongTK);
    }
}
