package com.example.FCI_Menofia.signUpAndLogin;

import com.example.FCI_Menofia.CustomFunctions;
import com.example.FCI_Menofia.DBconnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage {

    @FXML
    private Button exitFromButton;

    @FXML
    private Button goToSignUpButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    private TextField userNameTextField;
    String userName;
    String password;
    Connection connection;

    @FXML
    void signInButtonFunction(ActionEvent event) {
        userName = userNameTextField.getText();
        password = passwordField.getText();
        try {
            connection = DBconnector.getconnection();
            System.out.println("Connection Between Database and login page done ");
            ResultSet rs = connection.createStatement().executeQuery("select UserName , Password " +
                    "from studentsdatabase.signupdata " +
                    "where UserName = \"" + userName + "\"and Password = \"" + password + "\";");
            System.out.println("result set execution done successfully ##");
            if (rs.next()) {
                new CustomFunctions().gotToScene(signInButton, "mainPage.fxml");
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error !");
                alert.setHeaderText("Error in user name or  password Field");
                alert.setContentText("Error in user name or  password Field .. check you Data !!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println("Error while connecting with database in login page !! ");
        }

    }

    @FXML
    void signUpButtonFunction(ActionEvent event) {
        new CustomFunctions().gotToScene(goToSignUpButton, "signUpPage.fxml");
    }

    @FXML
    void ExitFromApp(ActionEvent event) {
        System.exit(0);
    }
}
