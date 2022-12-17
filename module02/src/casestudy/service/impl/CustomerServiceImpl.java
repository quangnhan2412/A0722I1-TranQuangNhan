package casestudy.service.impl;

import casestudy.models.person.Customer;
import casestudy.service.CustomerService;
import casestudy.ultils.RegexPerson;
import casestudy.validate.AgeException;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static casestudy.ultils.ReadAndWriteToCSV.readListCustomerTOCSV;
import static casestudy.ultils.ReadAndWriteToCSV.writeListCustomerToCSV;

public class CustomerServiceImpl implements CustomerService {
    public static final String PATH_CUSTOMER = "D:\\CodeGym\\Source Code\\A0722I1-TranQuangNhan\\module02\\src\\casestudy\\data\\customer.csv";

    static {
//        customerLinkedList.add(new Customer("Tran Quang Nhan", "01/02/2001", true, "201821774",
//                "0777472452", "tranquangnhan@dtu.com", "NV001", "Gold", "Da Nang"));
//        customerLinkedList.add(new Customer("Tran Quang Nhan2", "01-02-2001", false, "201821774",
//                "0777472452", "tranquangnhan@dtu.com", "NV002", "Gold", "Da Nang"));
//        customerLinkedList.add(new Customer("Tran Quang Nhan3", "01022001", true, "201821774",
//                "0777472452", "tranquangnhan@dtu.com", "NV003", "Gold", "Ha Noi"));
    }

    @Override
    public Customer CustomerInfo() {
        String fullName = RegexPerson.inputFullName();
        LocalDate dayOfBirth = null;
        try{
            dayOfBirth = RegexPerson.inputBirthday();
        }catch (AgeException e){
            System.out.println("AAA");
        }
        
        boolean gender = RegexPerson.inputGender();
        String identityCard = RegexPerson.inputNewIDCard();
        String phoneNumber = RegexPerson.inputNewNumberPhone();
        String email = RegexPerson.inputNewEmail();
        String customerID = RegexPerson.inputCustomerID();
        String customerType = RegexPerson.inputCustomerType();
        String address = RegexPerson.inputAddress();
        return new Customer(fullName, dayOfBirth, gender, identityCard, phoneNumber, email, customerID, customerType, address);

    }

    @Override
    public List findAll() {
        List<Customer> customerLinkedList = new LinkedList<>();
        return customerLinkedList;
    }

    @Override
    public void addCustomer() {
        List<Customer> customerLinkedList = new LinkedList<>();
        displayAll();
        customerLinkedList.add(CustomerInfo());
        writeListCustomerToCSV(customerLinkedList,PATH_CUSTOMER,false);
        displayAll();
    }

    @Override
    public void updateCustomer(String CustomerID) {
        List<Customer> customerLinkedList = readListCustomerTOCSV(PATH_CUSTOMER);
        displayAll();
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getCustomerID().equals(CustomerID)) {
                Customer newCustomer = CustomerInfo();
                customerLinkedList.set(i, newCustomer);
                writeListCustomerToCSV(customerLinkedList,PATH_CUSTOMER,false);
                return;
            }
        }
        System.out.println("Not found");
    }

    @Override
    public void displayAll() {
        List<Customer> customerLinkedList = readListCustomerTOCSV(PATH_CUSTOMER);
        if (customerLinkedList != null) {
            for (Customer customer : customerLinkedList) {
                System.out.println(customer);
            }
        }

    }
}
