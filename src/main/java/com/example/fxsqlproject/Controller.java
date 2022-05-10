package com.example.fxsqlproject;

import com.example.fxsqlproject.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button registerButton;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            String usernameInput = loginField.getText().trim();
            String passwordInput = passField.getText().trim();

            if (!usernameInput.equals("") && !passwordInput.equals(""))
                loginUser(usernameInput, passwordInput);
            else
                System.out.println("Please, enter username and password.");
        });

        registerButton.setOnAction(event -> {
            openNewScene("register-window.fxml");
        });
    }

    private void loginUser(String usernameInput, String passwordInput) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setUsername(usernameInput);
        user.setPassword(passwordInput);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (resultSet.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (counter >= 1) {
            System.out.println("Login success.");
            openNewScene("app.fxml");
        }
        else {
            Shake userLoginAnimation = new Shake(loginField);
            Shake passLoginAnimation = new Shake(passField);
            userLoginAnimation.playShakeAnimation();
            passLoginAnimation.playShakeAnimation();
        }
    }

    public void openNewScene(String window) {
        loginButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
