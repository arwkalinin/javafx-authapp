package com.example.fxsqlproject;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String address;
    private String gender;

    public User() {
        this.firstName = "No name";
        this.lastName = "No lastname";
        this.username = "No username";
        this.password = "";
        this.address = "No address";
        this.gender = "No gender";
    }
    public User(String firstName, String lastName, String username, String password, String address, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
