package bean.repository;

import bean.model.ToaNhaTComplex;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public interface ToaNhaRepository {
    public List<ToaNhaTComplex> selectAllToaNha();
    List<ToaNhaTComplex> searchThreeOne(String search);
    public boolean deleteToaNha(String id) throws SQLException;
    void addCustomer(ToaNhaTComplex toaNhaTComplex);
    List<ToaNhaTComplex> searchThree(@Nullable String searchName, @Nullable String idCard, @Nullable String searchPhone);
}
