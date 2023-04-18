package bean.service;

import bean.model.ToaNhaTComplex;

import java.sql.SQLException;
import java.util.List;

public interface ToaNhaService {
    public List<ToaNhaTComplex> selectAllToaNha();
    List<ToaNhaTComplex> searchThreeOne(String search);
    public boolean deleteToaNha(String id) throws SQLException;
    void addCustomer(ToaNhaTComplex toaNhaTComplex);
}
