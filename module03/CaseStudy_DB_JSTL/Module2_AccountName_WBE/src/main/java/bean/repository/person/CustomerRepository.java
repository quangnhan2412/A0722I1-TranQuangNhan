package bean.repository.person;

import bean.model.person.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAllCustomer();
    Customer getCustomerById(int id);

    List<Customer> searchCustomerById(int id);

    public boolean updateCustomer(Customer customer) throws SQLException;

    public boolean deleteCustomer(int id) throws SQLException;

    void addCustomer(Customer customer);

}
