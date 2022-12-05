package casestudy.service;


import casestudy.models.person.Customer;

import java.util.List;

public interface CustomerService extends Service {
    List findAll();

    void addCustomer();

    void updateCustomer(String CustomerID);

    Customer CustomerInfo();

}
