package com.example.FCI_Menofia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainPage {
    @FXML
    private Button deleteButton;
    @FXML
    private Button signOutButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button displayButton;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    void goToDeleteScreen(ActionEvent event) {
        new CustomFunctions().gotToScene(deleteButton, "displayStudents.fxml");
    }

    @FXML
    void goToDisplayScreen(ActionEvent event) {
        new CustomFunctions().gotToScene(displayButton, "displayStudents.fxml");
    }

    @FXML
    void goToSearchButton(ActionEvent event) {
        new CustomFunctions().gotToScene(searchButton, "searchPage.fxml");
    }

    @FXML
    void goToInsertScreen(ActionEvent event) {
        new CustomFunctions().gotToScene(insertButton, "insertPage.fxml");
    }

    @FXML
    void goToUpdateScreen(ActionEvent event) {
        new CustomFunctions().gotToScene(updateButton, "updatePage.fxml");
    }

    @FXML
    void signOutFunction(ActionEvent event) {
        new CustomFunctions().gotToScene(signOutButton, "loginPage.fxml");
    }
}
