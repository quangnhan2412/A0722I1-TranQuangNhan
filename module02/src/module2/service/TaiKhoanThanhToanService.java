package module2.service;

import casestudy.models.person.Employee;
import module2.model.TaiKhoanThanhToan;

public interface TaiKhoanThanhToanService extends Service{
    void add();
    void delete() ;
    void displayList();
    void searchList() ;
    TaiKhoanThanhToan inputInfo() ;
}
