package bean.service;

import bean.model.person.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public List<Customer> selectAllCustomer();

    List<Customer> searchCustomerById(int id);
    Customer getCustomerById(int id);

    public boolean updateCustomer(Customer customer) throws SQLException;

    public boolean deleteCustomer(int id) throws SQLException;

    void addCustomer(Customer customer);
}
