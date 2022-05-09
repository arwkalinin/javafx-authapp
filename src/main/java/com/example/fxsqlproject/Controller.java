package com.example.fxsqlproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    }


}
