package com.example.fxsqlproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
            registerButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("register-window.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });
    }

    private void loginUser(String usernameInput, String passwordInput) {
        System.out.println("You logged as " + usernameInput + " and " + passwordInput);
    }


}
