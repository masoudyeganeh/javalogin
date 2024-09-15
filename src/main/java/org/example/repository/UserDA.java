package org.example.repository;

import org.example.common.Jdbc;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDA() throws SQLException {
        this.connection = Jdbc.getConnection();
    }

    public User selectOneByUsernameAndPassword(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from Users where username = ? and password = ?");
        preparedStatement.setString(1, user.getUsename());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setUser_id(resultSet.getInt("user_id"));
        }
        return user;
    }

    public User selectOneByUsername(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from Users where username = ?");
        preparedStatement.setString(1, user.getUsename());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setUser_id(resultSet.getInt("user_id"));
        }
        return user;
    }

    public void Insert(User user) throws SQLException {
        preparedStatement = connection.prepareStatement("select user_seq.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setUser_id(resultSet.getInt("id"));
        preparedStatement = connection.prepareStatement("insert into Users values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, user.getUser_id());
        preparedStatement.setString(2, user.getCellphone());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getName());
        preparedStatement.setString(5, user.getFamily());
        preparedStatement.setString(6, user.getCellphone());
        preparedStatement.executeUpdate();
    }
    public void commit() throws SQLException {
        connection.commit();
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
