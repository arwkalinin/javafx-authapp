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
        signUpNewUser();
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        registerNewAccountButton.setOnAction(event -> {
            String firstName = nameField.getText();
            String lastName = surnameField.getText();
            String username = usernameField.getText();
            String pass = passField.getText();
            String address = addressField.getText();
            String gender = "";
            if ((sexMaleCheckBox.isSelected() && sexFemaleCheckBox.isSelected()) || (!sexMaleCheckBox.isSelected() && !sexFemaleCheckBox.isSelected()))
                gender = "Unknown";
            else if (sexMaleCheckBox.isSelected())
                gender = "Male";
            else
                gender = "Female";

            User user = new User(firstName,lastName,username,pass,address,gender);
            dbHandler.signupUser(user);
        });
    }

}
