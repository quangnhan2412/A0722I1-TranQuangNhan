package bean.repository.person;

import bean.model.person.Customer;
import bean.model.person.Employee;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    public List<Customer> selectAllCustomer();
    Customer getCustomerById(int id);

    List<Customer> searchCustomerById(int id);
    List<Customer> searchCustomerByName(String nameCustomer);

    public boolean updateCustomer(Customer customer) throws SQLException;

    public boolean deleteCustomer(int id) throws SQLException;
    public void deleteCustomerStr(List<Integer> id) throws SQLException;

    public List<Customer> getUsers(int offset, int limit);
    public int getTotalUsers();

    void addCustomer(Customer customer);
        List<Customer> searchThree(@Nullable String searchName, @Nullable String idCard,  @Nullable String searchPhone);
    List<Customer> searchThreeOne(String search);
}
