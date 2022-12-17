package module2.controller;

import module2.model.TaiKhoanThanhToan;
import module2.service.impl.TaiKhoanThanhToanServiceImpl;
import module2.ultils.RegexChoice;

public class BankController {
    static int choice = -1;

    public static void main(String[] args) {
        bankMenu();
    }
    static void displayMainMenu() {
        TaiKhoanThanhToanServiceImpl taiKhoanThanhToan = new TaiKhoanThanhToanServiceImpl();
        System.out.println("===CHUONG TRINH QUAN LY TAI KHOAN===");
        System.out.println("1. Them moi");
        System.out.println("2. Xoa");
        System.out.println("3. Xem danh sach TK ngan hang ");
        System.out.println("4. Tim kiem");
        System.out.println("5. Thoat");
        System.out.println("Enter your choice: ");
        choice = RegexChoice.inputChoiceMenu();
        switch (choice) {
            case 1:
                taiKhoanThanhToan.add();
                bankMenu();
                break;
            case 2:
                taiKhoanThanhToan.delete();
                bankMenu();
                break;
            case 3:
                taiKhoanThanhToan.displayAll();
                bankMenu();
                break;
            case 4:
                taiKhoanThanhToan.searchList();
                bankMenu();
                break;
            case 5:
                System.exit(5);
            default:
                System.out.println("No choice!");
                displayMainMenu();
        }
    }

    static void bankMenu() {

        System.out.println("===BanK===");
        System.out.println("1. Tai khoan tiet kiem");
        System.out.println("2. Tai khoan thanh toan");
        System.out.println("3. Thoat");
        System.out.println("Enter your choice: ");
        choice = RegexChoice.inputChoiceMenu();
        switch (choice) {
            case 1:
                System.out.println("===Tai khoan tiet kiem===");
                displayMainMenu();
                break;
            case 2:
                System.out.println("==Tai khoan thanh toan===");
                displayMainMenu();
                break;
            case 3:
                System.exit(3);
            default:
                System.out.println("No choice!");
                displayMainMenu();
        }
    }
}
