package com.example.fxsqlproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signupUser(String firstName, String lastName, String username,
                           String password, String address, String gender) {
        System.out.println("Trying to register");
        String insertToDB = "INSERT INTO " + Const.USER_TABLE + "(" +
                            Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                            Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                            Const.USERS_ADDRESS + "," + Const.USERS_GENDER + ")" +
                            "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insertToDB);
            prSt.setString(1, firstName);
            prSt.setString(2, lastName);
            prSt.setString(3, username);
            prSt.setString(4, password);
            prSt.setString(5, address);
            prSt.setString(6, gender);
            prSt.executeUpdate();
            System.out.println("Success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
