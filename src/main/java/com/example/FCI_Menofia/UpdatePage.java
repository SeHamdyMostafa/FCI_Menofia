package com.example.FCI_Menofia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.example.FCI_Menofia.student.StudentInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdatePage {

    @FXML
    private Button backToMainPageButton;

    @FXML
    private TextField nationalIdTextField;

    @FXML
    private Button getStudentInfo;

    @FXML
    private TextField studentCourse1TextField;

    @FXML
    private TextField studentCourse2TextField;

    @FXML
    private TextField studentCourse3TextField;

    @FXML
    private TextField studentCourse4TextField;

    @FXML
    private TextField studentCourse5TextField;

    @FXML
    private TextField studentCourse6TextField;

    @FXML
    private TextField studentDepartmentTextField;

    @FXML
    private TextField studentJpaTextField;

    @FXML
    private TextField studentLevelTextField;

    @FXML
    private TextField studentNameTextField;

    @FXML
    private TextField studentSectionTextField;

    @FXML
    private Button updateInfoButton;
    Connection connection;
    StudentInfo studentObj = new StudentInfo();

    @FXML
    void backToMainPage(ActionEvent event) {
        new CustomFunctions().gotToScene(updateInfoButton, "mainPage.fxml");
    }

    public String studentName;
    public String nationalId;
    public double studentJPA;
    public String studentSection;
    public String studentLevel;
    public String studentDepartment;
    public String studentCourse1;
    public String studentCourse2;
    public String studentCourse3;
    public String studentCourse4;
    public String studentCourse5;
    public String studentCourse6;

    @FXML
    void getStudentInfoFromDatabase(ActionEvent event) {
        ResultSet resultSet = null;
        Connection connection;
        try {
            nationalId = nationalIdTextField.getText();
            connection = DBconnector.getconnection();
            Statement stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select * from studentsdatabase.studentsinfo where nationalid = " + nationalId + ";");
            //TODO need to get data from result set and convert it with any datatype to be able to work on with
            if (resultSet.next()) {
                studentNameTextField.setText(resultSet.getString("NAME"));
                studentLevelTextField.setText(resultSet.getString("LEVEL"));
                studentDepartmentTextField.setText(resultSet.getString("DEPARTMENT"));
                studentSectionTextField.setText(resultSet.getString("SECTION"));
                studentJpaTextField.setText(resultSet.getString("JPA"));
                studentCourse1TextField.setText(resultSet.getString("COURSE1"));
                studentCourse2TextField.setText(resultSet.getString("COURSE2"));
                studentCourse3TextField.setText(resultSet.getString("COURSE3"));
                studentCourse4TextField.setText(resultSet.getString("COURSE4"));
                studentCourse5TextField.setText(resultSet.getString("COURSE5"));
                studentCourse6TextField.setText(resultSet.getString("COURSE6"));
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error done while Connecting with database in Update page !!");
        }
    }

    @FXML
    void updateStudentInfo(ActionEvent event) {
        try {
            connection = DBconnector.getconnection();
            Statement stmt = connection.createStatement();
            stmt.execute("delete from studentsdatabase.studentsinfo where nationalid = " + nationalId + ";");

            stmt.execute("INSERT INTO studentsdatabase.studentsinfo " +
                    "VALUES( \"" + studentNameTextField.getText() +
                    "\",\" " + studentLevelTextField.getText() +
                    "\",\" " + studentDepartmentTextField.getText() +
                    "\",\"" + studentSectionTextField.getText() +
                    "\"," + studentJpaTextField.getText() +
                    ",\" " + studentCourse1TextField.getText() +
                    "\",\" " + studentCourse2TextField.getText() +
                    "\",\" " + studentCourse3TextField.getText() +
                    "\",\" " + studentCourse4TextField.getText() +
                    "\",\" " + studentCourse5TextField.getText() +
                    "\",\" " + studentCourse6TextField.getText() +
                    "\",\" " + nationalIdTextField.getText() +
                    "\");");
            connection.close();
            new CustomFunctions().gotToScene(updateInfoButton, "updatePage.fxml");
        } catch (Exception E) {

        }

    }

}
