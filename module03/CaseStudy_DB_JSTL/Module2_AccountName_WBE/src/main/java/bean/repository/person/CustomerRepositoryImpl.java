package bean.repository.person;

import bean.DBConnection;
import bean.model.person.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {


    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_adress) VALUES " +
            " (?, ?, ?,?,?, ?, ?,?);";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id = ?";
    private static final String SELECT_CUSTOMER_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?,customer_name= ?, customer_birthday =? , " +
            "customer_gender =?,customer_id_card=?,customer_phone =?,customer_email =?,customer_adress =? where customer_id = ?;";
    private static final String SEARCH_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("customer_name");
                    String identityCard = rs.getString("customer_id_card");
                    Date dayOfBirth = rs.getDate("customer_birthday");
                    String phoneNumber = rs.getString("customer_phone");
                    String email = rs.getString("customer_email");
                    String address = rs.getString("customer_adress");
                    int customerId = rs.getInt("customer_id");
                    int customerTypeId = rs.getInt("customer_type_id");
                    boolean gender = rs.getBoolean("customer_gender");

                    Customer customer = new Customer(fullName, identityCard, dayOfBirth, phoneNumber, email, address, customerId, customerTypeId, gender);
                    customerList.add(customer);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("customer_name");
                    String identityCard = rs.getString("customer_id_card");
                    Date dayOfBirth = rs.getDate("customer_birthday");
                    String phoneNumber = rs.getString("customer_phone");
                    String email = rs.getString("customer_email");
                    String address = rs.getString("customer_adress");
                    int customerId = rs.getInt("customer_id");
                    int customerTypeId = rs.getInt("customer_type_id");
                    boolean gender = rs.getBoolean("customer_gender");
                    customer = new Customer(fullName, identityCard, dayOfBirth, phoneNumber, email, address, customerId, customerTypeId, gender);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return customer;
    }

    @Override
    public List<Customer> searchCustomerById(int id) {
        List<Customer> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String fullName = rs.getString("customer_name");
                    String identityCard = rs.getString("customer_id_card");
                    Date dayOfBirth = rs.getDate("customer_birthday");
                    String phoneNumber = rs.getString("customer_phone");
                    String email = rs.getString("customer_email");
                    String address = rs.getString("customer_adress");
                    int customerId = rs.getInt("customer_id");
                    int customerTypeId = rs.getInt("customer_type_id");
                    boolean gender = rs.getBoolean("customer_gender");

                    Customer customer = new Customer(fullName, identityCard, dayOfBirth, phoneNumber, email, address, customerId, customerTypeId, gender);
                    result.add(customer);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return result;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
                preparedStatement.setInt(1, customer.getCustomerTypeId());
                preparedStatement.setString(2, customer.getFullName());
                preparedStatement.setDate(3, (java.sql.Date) customer.getDayOfBirth());
                preparedStatement.setBoolean(4, customer.isGender());
                preparedStatement.setString(5, customer.getIdentityCard());
                preparedStatement.setString(6, customer.getPhoneNumber());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
                preparedStatement.setInt(9, customer.getCustomerId());

                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
                preparedStatement.setInt(1, id);
                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public void addCustomer(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
                preparedStatement.setInt(1, customer.getCustomerTypeId());
                preparedStatement.setString(2, customer.getFullName());
                preparedStatement.setDate(3, (java.sql.Date) customer.getDayOfBirth());
                preparedStatement.setBoolean(4, customer.isGender());
                preparedStatement.setString(5, customer.getIdentityCard());
                preparedStatement.setString(6, customer.getPhoneNumber());
                preparedStatement.setString(7, customer.getEmail());
                preparedStatement.setString(8, customer.getAddress());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }
}
