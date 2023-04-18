package bean.service;

import bean.model.person.Customer;
import bean.repository.person.CustomerRepository;
import bean.repository.person.CustomerRepositoryImpl;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> selectAllCustomer() {
        return customerRepository.selectAllCustomer();
    }

    @Override
    public List<Customer> searchCustomerById(int id) {
        return customerRepository.searchCustomerById(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String nameCustomer) {
        return customerRepository.searchCustomerByName(nameCustomer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public void deleteCustomerStr(List<Integer> id) throws SQLException {
        customerRepository.deleteCustomerStr(id);
    }


    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> searchThree(@Nullable String searchName, @Nullable String idCard, @Nullable String searchPhone) {
        return customerRepository.searchThree(searchName,idCard,searchPhone);
    }

    @Override
    public List<Customer> searchThreeOne(String search) {
        return customerRepository.searchThreeOne(search);
    }


}
