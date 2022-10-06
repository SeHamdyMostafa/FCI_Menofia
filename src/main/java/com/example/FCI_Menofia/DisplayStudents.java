package com.example.FCI_Menofia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.FCI_Menofia.student.StudentInfo;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class DisplayStudents implements Initializable {
    public static StudentInfo student = new StudentInfo();
    private String url = "jdbc:mysql://localhost/studentsdatabase";
    private String ResourceBundle = "resources";
    @FXML
    private Button backToMainPage;
    @FXML
    private TableColumn<modeltabel, String> course1;

    @FXML
    private TableColumn<modeltabel, String> course2;

    @FXML
    private TableColumn<modeltabel, String> course3;

    @FXML
    private TextField nationalIdForDelete;

    @FXML
    private TableColumn<modeltabel, String> course4;

    @FXML
    private TableColumn<modeltabel, String> course5;

    @FXML
    private TableColumn<modeltabel, String> course6;

    @FXML
    private TableColumn<modeltabel, String> department;

    @FXML
    private TableColumn<modeltabel, String> jpa;

    @FXML
    private TableColumn<modeltabel, String> level;

    @FXML
    private TableColumn<modeltabel, String> name;

    @FXML
    private TableColumn<modeltabel, String> section;

    @FXML
    private TableColumn<modeltabel, String> nationalid;

    @FXML
    private TableView<modeltabel> tabel;

    @FXML
    private Button delbutton;

    boolean nationalidIsTrue = false;

    boolean allIsTrue = false;


    ObservableList<modeltabel> oblist = FXCollections.observableArrayList();

    public void displayStudents() { // Function to display all com.example.FCI_Menofia.student in table

        try {
            tabel.getItems().clear(); // function that used to clear the content of the table
            Connection con = DBconnector.getconnection();
            System.out.println("Connection with database done  ## in display page");
            ResultSet rs = con.createStatement().executeQuery("select * from studentsdatabase.studentsinfo order by LEVEL;");
            System.out.println("SetResults done ##");
            while (rs.next()) {
                oblist.add(new modeltabel(rs.getString("name"), rs.getString("level"), rs.getString("department"), rs.getString("section"), rs.getString("jpa"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"), rs.getString("course4"), rs.getString("course5"), rs.getString("course6"), rs.getString("nationalid")));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error while connecting with database in display page"   );
        }

        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        level.setCellValueFactory(new PropertyValueFactory<>("level"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        section.setCellValueFactory(new PropertyValueFactory<>("section"));
        jpa.setCellValueFactory(new PropertyValueFactory<>("jpa"));
        course1.setCellValueFactory(new PropertyValueFactory<>("course1"));
        course2.setCellValueFactory(new PropertyValueFactory<>("course2"));
        course3.setCellValueFactory(new PropertyValueFactory<>("course3"));
        course4.setCellValueFactory(new PropertyValueFactory<>("course4"));
        course5.setCellValueFactory(new PropertyValueFactory<>("course5"));
        course6.setCellValueFactory(new PropertyValueFactory<>("course6"));
        nationalid.setCellValueFactory(new PropertyValueFactory<>("nationalid"));

        tabel.setItems(oblist);
    }

    public void initialize(URL location, ResourceBundle resources) {
        displayStudents();
    }

    @FXML
    void backToMainPage(ActionEvent event) {
        new CustomFunctions().gotToScene(backToMainPage, "mainPage.fxml");
    }

    modeltabel m = new modeltabel();


    @FXML
    void deleteStudentFromDatabase(ActionEvent event) {
        allIsTrue = false;
        nationalidIsTrue = false;
        String nationalId = nationalIdForDelete.getText();
        String deletingStudentSqlCommand = "Delete from studentsdatabase.studentsinfo where nationalid = " + nationalId + ";";
        try {
            Connection con = DBconnector.getconnection();
            System.out.println("Connection with database done  ## in display page");
            Statement stmt = con.createStatement();
            try {
                stmt.execute(deletingStudentSqlCommand);
                displayStudents();
                con.close();
            } catch (Exception e) {
                System.out.println("Entered value is not allowed !! ");
            }
        } catch (Exception e) {
            System.out.println("Error in db while deleting com.example.FCI_Menofia.student !!");
        }

        /*
         *
         * National id checking
         *
         */
        // get national id of com.example.FCI_Menofia.student
        student.nationalId = nationalIdForDelete.getText();
        if (nationalIdForDelete.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("National ID Input Error !");
            alert.setHeaderText("you can't leave National ID Field empty ");
            alert.setContentText("Student National id must be inserted !! ");
            alert.showAndWait();
        } else if (student.nationalId.length() != 14) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("National ID Input Error !");
            alert.setHeaderText("Error in National ID Field");
            alert.setContentText("National id can't be less than 14 Digit !! ");
            alert.showAndWait();
        }

        // TODO
        // if the id is not exist in database .
//
//        else{
//            System.out.println("national id in text Field -> "+nationalIdForDelete.getText());
//            System.out.println("local national id -> "+nationalId);
//            if (nationalIdForDelete.getText() != nationalId ) {
//
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("National ID Input Error !");
//                alert.setHeaderText("Error in National ID Field");
//                alert.setContentText("this id not found!! ");
//                alert.showAndWait();
//            }
//        }


    }


}
