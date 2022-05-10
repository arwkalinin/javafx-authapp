package com.example.fxsqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signupUser(User user) {
        String insertToDB = "INSERT INTO " + Const.USER_TABLE + "(" +
                            Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                            Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                            Const.USERS_ADDRESS + "," + Const.USERS_GENDER + ")" +
                            "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insertToDB);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getAddress());
            prSt.setString(6, user.getGender());
            prSt.executeUpdate();
            System.out.println("Registration success!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resultSet = null;

        String selectFromSQL = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(selectFromSQL);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resultSet;
    }

}
