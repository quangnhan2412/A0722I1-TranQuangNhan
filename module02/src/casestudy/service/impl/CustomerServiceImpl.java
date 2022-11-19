package casestudy.service.impl;

import casestudy.models.Customer;
import casestudy.service.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static LinkedList<Customer> customerLinkedList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    static {
        customerLinkedList.add(new Customer("Tran Quang Nhan", "01-02-2009", true, "201821774",
                "0777472452", "tranquangnhan@dtu.com", "NV001", "Gold", "Da Nang"));
        customerLinkedList.add(new Customer("Tran Quang Nhan2", "01-02-2009", false, "201821774",
                "0777472452", "tranquangnhan@dtu.com", "NV002", "Gold", "Da Nang"));
        customerLinkedList.add(new Customer("Tran Quang Nhan3", "01-02-2009", true, "201821774",
                "0777472452", "tranquangnhan@dtu.com", "NV003", "Gold", "Ha Noi"));
    }

    @Override
    public Customer CustomerInfo() {
        System.out.println("Enter full name : ");
        String fullName = scanner.nextLine();
        System.out.println("Enter date of birth: ");
        String birthDays = scanner.nextLine();
        System.out.println("Enter true (male) or incorrect (female) gender : ");
        boolean newGender = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("Enter identification card : ");
        String newIDCard = scanner.nextLine();
        System.out.println("Enter number phone : ");
        String newNumberPhone = scanner.nextLine();
        System.out.println("Enter email: ");
        String newEmail = scanner.nextLine();
        System.out.println("Enter employee ID  ");
        String newEmployeeID = scanner.nextLine();
        System.out.println("Enter customerType  ");
        String customerType = scanner.nextLine();
        System.out.println("Enter address  ");
        String address = scanner.nextLine();
        return new Customer(fullName, birthDays, newGender, newIDCard, newNumberPhone, newEmail, newEmployeeID, customerType, address);
    }

    @Override
    public List findAll() {
        return customerLinkedList;
    }

    @Override
    public void addCustomer() {
        customerLinkedList.add(CustomerInfo());
        disPlayAll();
    }

    @Override
    public void updateCustomer(String CustomerID) {
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getCustomerID().equals(CustomerID)) {
                Customer newCustomer = CustomerInfo();
                customerLinkedList.set(i, newCustomer);
                return;
            }
        }
            System.out.println("Not found");
    }


    @Override
    public void disPlayAll() {
        for (Customer customer : customerLinkedList) {
            System.out.println(customer);
        }
    }
}
