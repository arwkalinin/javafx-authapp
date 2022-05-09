package com.example.fxsqlproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private AnchorPane passwordField;

    @FXML
    private Button registerButton;

    @FXML
    void initialize() {
        loginButton.setOnAction(event -> {
            System.out.println("You clicked on loginButton.");
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


}
