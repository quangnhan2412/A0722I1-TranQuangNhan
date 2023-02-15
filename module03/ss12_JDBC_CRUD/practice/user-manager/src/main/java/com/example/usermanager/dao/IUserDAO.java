package com.example.usermanager.dao;

import com.example.usermanager.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public List<User> sortByName();

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    List<User> searchUserByCountry(String inputCountry);

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permission);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();

    public List<User> viewAllUsersStore();

    public boolean UpdateUserSP(User user)  throws SQLException;
    public boolean deleteSP(int id)  throws SQLException;


}

 public Map<Integer, String> selectAllPosition() {
        Map<Integer, String> positionMap = new LinkedHashMap<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                positionMap.put(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionMap;
    }
