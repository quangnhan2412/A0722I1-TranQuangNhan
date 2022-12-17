package module2.service.impl;

import module2.model.TaiKhoanNganHang;
import module2.model.TaiKhoanTietKiem;
import module2.service.TaiKhoanTietKiemService;

import java.util.ArrayList;

import static module2.ultils.ReadAndWriteFileCSV.readFromFile;

public class TaiKhoanTietKiemServiceImpl implements TaiKhoanTietKiemService {
    public static final String PATH_ACCOUNT = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\module2\\data\\bank_accounts.csv";

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

    }

    @Override
    public void deleteEmployee() {

    }

    @Override
    public void displayList() {

    }

    @Override
    public void searchEmployee() {

    }

    @Override
    public TaiKhoanTietKiem inputInfo() {
        return null;
    }
}
