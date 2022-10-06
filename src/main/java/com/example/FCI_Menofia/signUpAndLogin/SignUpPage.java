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

public class SignUpPage {

    @FXML
    private Button backToLoginPageButton;

    @FXML
    private PasswordField confirmPasswordTextField;

    @FXML
    private TextField employeeFirstNameTextField;

    @FXML
    private TextField employeeLastNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField userNameTextField;


    String firstName;
    String lastName;
    String userName;
    String password;
    String passwordConfirmation;
    // flags used to check if all is right or not !!
    boolean firstNameIsTrue = false;
    boolean lastNameIsTrue = false;
    boolean userNameIsTure = false;
    boolean passwordIsTrue = false;
    boolean passwordConfirmationIsTrue = false;
    Connection connection;

    @FXML
    void backToLoginPageButtonFunction(ActionEvent event) {
        new CustomFunctions().gotToScene(backToLoginPageButton, "loginPage.fxml");
    }

    @FXML
    void signUpButtonFunction(ActionEvent event) {
        /*
         *
         * assign variables with data from GUI
         *
         */
        firstName = employeeFirstNameTextField.getText();
        lastName = employeeLastNameTextField.getText();
        userName = userNameTextField.getText();
        password = passwordTextField.getText();
        passwordConfirmation = confirmPasswordTextField.getText();
        System.out.println("First name -> " + firstName);
        System.out.println("Last name -> " + lastName);
        System.out.println("userName -> " + userName);
        System.out.println("password -> " + password);
        System.out.println("Confirm Password -> " + passwordConfirmation);
        /*
         *
         * Check on first name
         *
         */
        if (firstName.length() == 0) {
            firstNameIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("First Name Input Error !");
            alert.setHeaderText("Error in First Name Field");
            alert.setContentText("you can't leave first name field empty !!");
            alert.showAndWait();
        } else {
            // convert String to chars to be able to compare it as integer values
            char[] nameInCahracters = firstName.toCharArray();
            // for each loop to compare
            for (int x : nameInCahracters) {
                if ((x >= 65 && x <= 90) || (x >= 97 && x <= 122) || x == 32) {
                    firstNameIsTrue = true;
                } else {
                    firstNameIsTrue = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("First Name input Error !");
                    alert.setHeaderText("Error in First Name Field");
                    alert.setContentText("First Name Must be characters only !!");
                    alert.showAndWait();
                    break;
                }
            }
        }
        /*
         *
         * Check last name
         *
         */
        if (lastName.length() == 0) {
            lastNameIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Name Input Error !");
            alert.setHeaderText("Error in Last Name Field");
            alert.setContentText("you can't leave last name field empty !!");
            alert.showAndWait();
        } else {
            // convert String to chars to be able to compare it as integer values
            char[] nameInCahracters = lastName.toCharArray();
            // for each loop to compare
            for (int x : nameInCahracters) {
                if ((x >= 65 && x <= 90) || (x >= 97 && x <= 122) || x == 32) {
                    lastNameIsTrue = true;
                } else {
                    lastNameIsTrue = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Last Name input Error !");
                    alert.setHeaderText("Error in Last Name Field");
                    alert.setContentText("Last Name Must be characters only !!");
                    alert.showAndWait();
                    break;
                }
            }
        }
        /*
         *
         * Check user name
         *
         */
        if (userName.length() == 0) {
            userNameIsTure = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("user name Input Error !");
            alert.setHeaderText("Error in user Name Field");
            alert.setContentText("you can't leave user name field empty !!");
            alert.showAndWait();
        } else {
            char[] userNameInCharArray = userName.toCharArray();
            int firstItemInUserNameInIntCast = (int) userNameInCharArray[0];
            if ((firstItemInUserNameInIntCast >= 65 && firstItemInUserNameInIntCast <= 90) || (firstItemInUserNameInIntCast >= 97 && firstItemInUserNameInIntCast <= 122)) {
                for (int x : userNameInCharArray) {
                    if (x == 32) {
                        userNameIsTure = false;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("user name Input Error !");
                        alert.setHeaderText("Error in user Name Field");
                        alert.setContentText("user name can't contain White spaces !!");
                        alert.showAndWait();
                        break;
                    } else if (x < 0 || (x > 10 && x < 47) || (x > 58 && x < 65) || (x > 90 && x < 97) || x > 122) { // user name must be characters and Numbers only
                        userNameIsTure = false;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("user name Input Error !");
                        alert.setHeaderText("Error in user Name Field");
                        alert.setContentText("user name must contain numbers and characters only !!");
                        alert.showAndWait();
                        break;
                    } else {
                        userNameIsTure = true;
                    }
                }
            } else {
                userNameIsTure = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("user name Input Error !");
                alert.setHeaderText("Error in user Name Field");
                alert.setContentText("user name must start with Character !!");
                alert.showAndWait();
            }

        }
        /*
         *
         * passwordField check
         *
         */
        if (password.length() == 0) { // if the Password Field is empty
            passwordIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("password Input Error !");
            alert.setHeaderText("Error in password Field");
            alert.setContentText("password field can't be empty !!");
            alert.showAndWait();
        } else {
            if (password.length() < 8) { // if the password length is less than 8
                passwordIsTrue = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("password Input Error !");
                alert.setHeaderText("Error in password Field");
                alert.setContentText("password length must be more than 8 !!");
                alert.showAndWait();
            } else {
                char[] passwordInCharArray = password.toCharArray();
                for (int x : passwordInCharArray) {
                    if (x == 32) { // check if the password contain any white spaces .. it's not valid !!
                        passwordIsTrue = false;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("password Input Error !");
                        alert.setHeaderText("Error in password Field");
                        alert.setContentText("password can't contain White spaces !!");
                        alert.showAndWait();
                        break;
                    } else { // the password is right .. pass #
                        passwordIsTrue = true;
                    }
                }
            }
        }

        /*
         *
         * Confirmation Field Check
         *
         */

        if (passwordConfirmation.equals(password)) {
            passwordConfirmationIsTrue = true;
        } else {
            passwordConfirmationIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("password Confirmation Error !");
            alert.setHeaderText("Error in password Confirmation Field");
            alert.setContentText("password and password confirmation must be the same !!");
            alert.showAndWait();
        }



        /*
         *
         * Enter data to database ->
         *
         */
        try {
            connection = DBconnector.getconnection();
            ResultSet rs = connection.createStatement().executeQuery("select * from studentsdatabase.signupdata where UserName = \"" + userName + "\";");
            // if the user name is already exist .. then give the user error .. else add the new user into database .
            if (rs.next()) {
                userNameIsTure = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("user name Input Error !");
                alert.setHeaderText("Error in user name Field");
                alert.setContentText("User Name is Already exist .. try another one :) !!");
                alert.showAndWait();
            } else {
                userNameIsTure = true;
                if ((userNameIsTure == true &&
                        passwordIsTrue == true &&
                        firstNameIsTrue == true &&
                        lastNameIsTrue == true &&
                        passwordConfirmationIsTrue == true)
                ) {
                    String sqlCommand = "insert into studentsdatabase.signupdata(FirstName,LastName,UserName,Password) values( \""
                            + firstName + "\",\""
                            + lastName + "\",\""
                            + userName + "\",\""
                            + password + "\");";
                    System.out.println("SQL Command -> " + sqlCommand);
                    Statement stmt = connection.createStatement();
                    stmt.execute(sqlCommand);
                    System.out.println("Insert new employee to DB Done ##");
                    connection.close();
                    new CustomFunctions().gotToScene(signUpButton, "loginPage.fxml");
                } else {
                    System.out.println("some thing is not true in all fields !! ");
                }
            }
        } catch (Exception e) {
            System.out.println("Error while connecting with database in Sign Up page !! ");
        }
    }

}
