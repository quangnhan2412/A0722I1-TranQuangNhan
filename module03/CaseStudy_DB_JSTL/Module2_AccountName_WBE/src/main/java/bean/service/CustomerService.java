package bean.service;

import bean.model.person.Customer;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public List<Customer> selectAllCustomer();

    List<Customer> searchCustomerById(int id);

    List<Customer> searchCustomerByName(String nameCustomer);
    Customer getCustomerById(int id);

    public boolean updateCustomer(Customer customer) throws SQLException;

    public boolean deleteCustomer(int id) throws SQLException;
    public void deleteCustomerStr(List<Integer> id) throws SQLException;
    void addCustomer(Customer customer);
    List<Customer> searchThree(@Nullable String searchName, @Nullable String idCard,  @Nullable String searchPhone);
    List<Customer> searchThreeOne(String search);

}
