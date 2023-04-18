package bean.service;

import bean.model.ToaNhaTComplex;
import bean.repository.ToaNhaRepository;
import bean.repository.ToaNhaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ToaNhaServiceImpl implements ToaNhaService{
    private ToaNhaRepository toaNhaRepository = new ToaNhaRepositoryImpl();
    @Override
    public List<ToaNhaTComplex> selectAllToaNha() {
        return toaNhaRepository.selectAllToaNha();
    }

    @Override
    public List<ToaNhaTComplex> searchThreeOne(String search) {
        return toaNhaRepository.searchThreeOne(search);
    }

    @Override
    public boolean deleteToaNha(String id) throws SQLException {
        return toaNhaRepository.deleteToaNha(id);
    }

    @Override
    public void addCustomer(ToaNhaTComplex toaNhaTComplex) {
        toaNhaRepository.addCustomer(toaNhaTComplex);
    }
}
