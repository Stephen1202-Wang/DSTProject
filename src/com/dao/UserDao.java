package com.dao;

import com.bean.User;
import com.dbutils.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao{
    public void saveUser(User user) {
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into user_info(username,key_value) values (?,?)");
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getKey_value());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        DBUtils.execSQL(connection -> {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select username, key_value from user_info");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String key_value = resultSet.getString("key_value");
                    User user = new User(username, key_value);
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return users;
    }
}
