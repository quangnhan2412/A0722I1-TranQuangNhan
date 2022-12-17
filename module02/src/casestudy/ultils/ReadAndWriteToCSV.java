package casestudy.ultils;


import casestudy.models.person.Customer;
import casestudy.models.person.Employee;

import java.io.*;
import java.util.*;

import static casestudy.validate.Validator.*;


public class ReadAndWriteToCSV {

    //*Write
    private static void writeListStringTOCSV(List<String> stringList, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Err File!!!");
        }
    }

    //Employee
    public static void writeListEmployeeTOCSV(List<Employee> employeeList, String pathFile, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getInfo());
        }
        writeListStringTOCSV(stringList, pathFile, append);
    }

    //Customer
    public static void writeListCustomerToCSV(List<Customer> customersList, String pathFile, boolean append) {
        List<String> stringList = new LinkedList<>();
        for (Customer customer : customersList) {
            stringList.add(customer.getInfo());
        }
        writeListStringTOCSV(stringList, pathFile, append);
    }

    //*Read
    private static List<String> readListStringTOCSV(String pathFile) {
        List<String> listString = new ArrayList<>();
        File file = new File(pathFile);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listString.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Err File!!!");
        }
        return listString;
    }

    //Employee
    public static List<Employee> readListEmployeeTOCSV(String pathFile) {
        List<Employee> employeeList = new ArrayList<>();
        List<String> stringList = readListStringTOCSV(pathFile);
        for (String line : stringList) {
            String[] array = line.split(",");
            Employee employee = new Employee(array[0], dateInputDOB(array[1]), Boolean.parseBoolean(array[2]), array[3],
                    array[4], array[5], array[6], array[7], Double.parseDouble(array[8]), array[9]);
            employeeList.add(employee);
        }
        return employeeList;
    }

    //Customer
    public static List<Customer> readListCustomerTOCSV(String pathFile) {
        List<Customer> customerList = new LinkedList<>();
        List<String> stringList = readListStringTOCSV(pathFile);
        for (String line : stringList) {
            String[] linked = line.split(",");
            Customer customer = new Customer(linked[0], dateInputDOB(linked[1]), Boolean.parseBoolean(linked[2]), linked[3], linked[4]
                    , linked[5], linked[6], linked[7], linked[8]);
            customerList.add(customer);
        }
        return customerList;
    }


}

