package com.example.FCI_Menofia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;

public class SearchPage {

    @FXML
    private Button backToMainPageButton;

    @FXML
    private TableColumn<?, ?> course1;

    @FXML
    private TableColumn<?, ?> course2;

    @FXML
    private TableColumn<?, ?> course3;

    @FXML
    private TableColumn<?, ?> course4;

    @FXML
    private TableColumn<?, ?> course5;

    @FXML
    private TableColumn<?, ?> course6;

    @FXML
    private TableColumn<?, ?> department;
    @FXML
    private TableView<modeltabel> tabel;

    @FXML
    private TableColumn<?, ?> jpa;

    @FXML
    private TableColumn<?, ?> level;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private Button searchButton;

    ObservableList<modeltabel> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<?, ?> section;

    @FXML
    void backToMainPage(ActionEvent event) {
        new CustomFunctions().gotToScene(backToMainPageButton, "mainPage.fxml");
    }

    @FXML
    void searchForStudentInDatabaseUsingNationalId(ActionEvent event) {
        try {
            String studentNationalId = searchTextField.getText();
            tabel.getItems().clear(); // function that used to clear the content of the delete page
            Connection con = DBconnector.getconnection();
            System.out.println("Connection with database done  ## in display page");
            ResultSet rs = con.createStatement().executeQuery("select * from studentsdatabase.studentsinfo where nationalid = " + studentNationalId + ";");
            System.out.println("SetResults done ##");
            while (rs.next()) {
                oblist.add(new modeltabel(rs.getString("name"), rs.getString("level"), rs.getString("department"), rs.getString("section"), rs.getString("jpa"), rs.getString("course1"), rs.getString("course2"), rs.getString("course3"), rs.getString("course4"), rs.getString("course5"), rs.getString("course6"), rs.getString("nationalid")));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error while connecting with database in display page");
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
        tabel.setItems(oblist);
    }


}

