package bean.repository.person;

import bean.DBConnection;
import bean.model.person.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String SELECT_ID_EMPLOYEE = "select * from employee where id = ?";
    private static final String SELECT_NAME_EMPLOYEE = "select * from employee where name like ?";
    private static final String DELETE_EMPLOYEE_BY_ID = "delete from employee where id = ?;";
    private static final String SELECT_POSITION = "select * from position";
    private static final String SELECT_EDUCATION_DEGREE = "select * from education_degree;";
    private static final String SELECT_DIVISION = "select * from division";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (`name`, `date_of_birth`, `id_card`, `salary`, `phone_number`, `email`, `address`, `position_id`, `education_degree_id`, `division_id`) \n" + "VALUES \n" + "( ?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE ="update  employee set  `name` = ?, `date_of_birth` = ?, `id_card` = ?, \n" +
            "`salary` = ?, `phone_number` =?, `email` = ?, `address`= ?, `position_id`= ?, \n" +
            "`education_degree_id`= ?, `division_id`= ?\n" +
            "where id =?;";
    private static final String SEARCH_EMPLOYEE ="select * from employee\n" + "where `name` like ? and salary < ? and position_id = ?;";
    private static final String SEARCH_EMPLOYEE_BY_NAME_SALARY ="select * from employee\n" + "where name like ? and salary < ?;";

    public EmployeeRepositoryImpl() {
    }

    @Override
    public List<Employee> selectAllEmployee() {
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        List<Employee> employeeList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                rs = preparedStatement.executeQuery();

                Employee employee = null;
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    Date dateOfBirth = rs.getDate("date_of_birth");
                    String idCard = rs.getString("id_card");
                    double salary = rs.getDouble("salary");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    int positionId = rs.getInt("position_id");
                    int educationDegreeId = rs.getInt("education_degree_id");
                    int divisionId = rs.getInt("division_id");
                    String userName = rs.getString("username");

                    employee = new Employee(id, name, dateOfBirth, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName);
                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
                DBConnection.close();
            }
        }
        return employeeList;
    }

    @Override
    public Employee selectEmployee(int idKey) {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ID_EMPLOYEE);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    Date dateOfBirth = rs.getDate("date_of_birth");
                    String idCard = rs.getString("id_card");
                    double salary = rs.getDouble("salary");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    int positionId = rs.getInt("position_id");
                    int educationDegreeId = rs.getInt("education_degree_id");
                    int divisionId = rs.getInt("division_id");
                    String userName = rs.getString("username");

                    employee = new Employee(id, name, dateOfBirth, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName);
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
                DBConnection.close();
            }
        }
        return employee;
    }

    @Override
    public List<Employee> selectEmployee(String keyName) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_NAME_EMPLOYEE);
                preparedStatement.setString(1, "%" + keyName + "%");
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    Date dateOfBirth = rs.getDate("date_of_birth");
                    String idCard = rs.getString("id_card");
                    double salary = rs.getDouble("salary");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    int positionId = rs.getInt("position_id");
                    int educationDegreeId = rs.getInt("education_degree_id");
                    int divisionId = rs.getInt("division_id");
                    String userName = rs.getString("username");

                    employee = new Employee(id, name, dateOfBirth, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName);
                    employeeList.add(employee);
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDelete = false;
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
                preparedStatement.setInt(1, id);
                rowDelete = preparedStatement.executeUpdate() > 0;
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
                DBConnection.close();
            }
        }
        return rowDelete;
    }

    @Override
    public Map<Integer, String> selectAllPosition() {
        Map<Integer, String> positionMap = new LinkedHashMap<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_POSITION);
                rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    positionMap.put(id, name);
                }
            } catch (SQLException e) {
                printSQLException(e);
            } finally {
                try {
                    rs.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    printSQLException(e);
                }
                DBConnection.close();
            }
        }
        return positionMap;
    }

    @Override
    public Map<Integer, String> selectAllEducationDegree() {
        Map<Integer, String> educationDegreeMap = new LinkedHashMap<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                educationDegreeMap.put(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                rs.close();
                preparedStatement.close();
            } catch (SQLException e) {
                printSQLException(e);
            }
            DBConnection.close();
        }
        return educationDegreeMap;
    }

    @Override
    public Map<Integer, String> selectAllDivision() {
        Map<Integer, String> divisionMap = new LinkedHashMap<>();
        Connection connection = DBConnection.getConnection();
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_DIVISION);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                divisionMap.put(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                rs.close();
                preparedStatement.close();
            } catch (SQLException e) {
                printSQLException(e);
            }
            DBConnection.close();
        }
        return divisionMap;
    }

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
        preparedStatement.setString(1, employee.getFullName());
        preparedStatement.setString(2, String.valueOf(employee.getDayOfBirth()));
        preparedStatement.setString(3, employee.getIdentityCard());
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.setString(5, employee.getPhoneNumber());
        preparedStatement.setString(6, employee.getEmail());
        preparedStatement.setString(7, employee.getAddress());
        preparedStatement.setInt(8, employee.getPositionId());
        preparedStatement.setInt(9, employee.getEducationDegreeId());
        preparedStatement.setInt(10, employee.getDivisionId());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getFullName());
            preparedStatement.setString(2, String.valueOf(employee.getDayOfBirth()));
            preparedStatement.setString(3, employee.getIdentityCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, employee.getEmployeeId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                printSQLException(e);
            }
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public List<Employee> search(String searchName, double searchSalary, int searchPositionId) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setDouble(2, searchSalary);
            preparedStatement.setInt(3, searchPositionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                employeeList.add(new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public List<Employee> selectEmployeeByNameSalary(String searchName, double searchSalary) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME_SALARY);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setDouble(2, searchSalary);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date dateOfBirth = resultSet.getDate("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                employeeList.add(new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
