package com.example.usermanager.dao;

import com.example.usermanager.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3308/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    private static final String SEARCH_USERS_BY_COUNTRY = "select * from users where country = ?;";
    private static final String SORT_USERS_BY_NAME = "select * from users  order by name;";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<User> sortByName() {
        //Bước 1: Thiết lập kết nối
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_USERS_BY_NAME);) {
            System.out.println(preparedStatement);
            // Step 3:Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
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


    @Override
    public List<User> selectAllUsers() {
        //Sử dụng Try-With-Resources để tránh đóng tài nguyên (Mã tấm nồi hơi)
        List<User> users = new ArrayList<>();
        //Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             // Step 2:Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3:Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public List<User> searchUserByCountry(String inputCountry) {
        List<User> result = new ArrayList<>();
        //Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
//        Bước 2: Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USERS_BY_COUNTRY);) {
            preparedStatement.setString(1, inputCountry);
            System.out.println(preparedStatement);
//        Bước 3: Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();
//        Bước 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                System.err.println(rs.getInt("id"));
                System.err.println(rs.getString(rs.getInt("id")));
                int id=  rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");

              User user = new User(id, name, email, country);
              result.add(user);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println("test: " + result.size());
        return result;
    }
    @Override
    public User selectUser(int id) {
        User user = null;
//        Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
//        Bước 2: Tạo câu lệnh bằng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
//        Bước 3: Thực hiện truy vấn hoặc truy vấn cập nhật
            ResultSet rs = preparedStatement.executeQuery();
//        Bước 4: Xử lý đối tượng resultset.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }


}
