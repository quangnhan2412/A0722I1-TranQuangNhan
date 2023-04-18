package bean.repository.person;

import bean.DBConnection;
import bean.model.person.Customer;
import bean.model.person.Employee;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {


    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer" + "  (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_adress) VALUES " +
            " (?, ?, ?,?,?, ?, ?,?)";
    private static final String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id = ?";

    private static final String SELECT_CUSTOMER_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?,customer_name= ?, customer_birthday =? , " +
            "customer_gender =?,customer_id_card=?,customer_phone =?,customer_email =?,customer_adress =? where customer_id = ?;";
    private static final String SEARCH_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";
    private static final String DELETE_CUSTOMER_BY_NAME = "delete * from customer where customer_name = ?";
    private static final String SEARCH_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?";

        private static final String SEARCH_CUSTOMER = "select * from customer  where `customer_name` like ? and customer_id_card like  ? and customer_phone like ?;";
    private static final String SEARCH_CUSTOMER_TWO = "select * from customer  where `customer_name` like ? or customer_id_card =  ? or customer_birthday = ?;";


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
    public List<Customer> searchCustomerByName(String nameCustomer) {
        List<Customer> result = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        CallableStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareCall("{call search_customer_by_name(?)}");
                preparedStatement.setString(1, nameCustomer);
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
    public void deleteCustomerStr(List<Integer> id) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(DELETE_CUSTOMER_BY_ID);
            for (int i = 0; i < id.size(); i++) {
                stmt.setInt(1, id.get(i));
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List<Customer> getUsers(int offset, int limit) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {

            // Thực thi truy vấn lấy danh sách user
            String query = "SELECT * FROM cutomer LIMIT ?, ?,?,?,?,?,?,?,?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, offset);
            statement.setInt(2, limit);
            rs = statement.executeQuery();

            // Lấy dữ liệu từ ResultSet và đưa vào danh sách
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
            e.printStackTrace();
        } finally {
            // Giải phóng các tài nguyên
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return customerList;
    }

    @Override
    public int getTotalUsers() {
        int total = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Kết nối đến cơ sở dữ liệu

            // Thực thi truy vấn lấy tổng số lượng user
            String query = "SELECT COUNT(*) FROM customer";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            // Đọc kết quả truy vấn và lấy tổng số lượng user
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Giải phóng các tài nguyên
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return total;
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

    @Override
    public List<Customer> searchThree(@Nullable String searchName, @Nullable String idCard, @Nullable String searchPhone) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            if (searchName == null) searchName = "";
            if (searchPhone == null) searchPhone = "";
            if (idCard == null) idCard = "";

            searchName = searchName.trim();
            searchPhone = searchPhone.trim();
            idCard = idCard.trim();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setString(2, "%" + idCard + "%");
            preparedStatement.setString(3, "%" + searchPhone + "%");

            ResultSet rs = preparedStatement.executeQuery();
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> searchThreeOne(String search) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_TWO);
                preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, search);
            preparedStatement.setDate(3, java.sql.Date.valueOf(search));

            ResultSet rs = preparedStatement.executeQuery();
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
