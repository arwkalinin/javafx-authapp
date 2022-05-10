package com.example.fxsqlproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterController {

    @FXML
    private TextField addressField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passField;

    @FXML
    private AnchorPane passwordField;

    @FXML
    private Button registerNewAccountButton;

    @FXML
    private CheckBox sexFemaleCheckBox;

    @FXML
    private CheckBox sexMaleCheckBox;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField usernameField;

    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        registerNewAccountButton.setOnAction(event -> {
            System.out.println("hello");
            dbHandler.signupUser(nameField.getText(), surnameField.getText(), usernameField.getText(),
                                 passField.getText(), addressField.getText(), "Male");
        });
    }

}
