package module2.service;

import module2.model.TaiKhoanTietKiem;

public interface TaiKhoanTietKiemService extends Service {
    void add();
    void deleteEmployee() ;
    void displayList();
    void searchEmployee() ;
    TaiKhoanTietKiem inputInfo() ;
}
