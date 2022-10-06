package com.example.FCI_Menofia;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomFunctions {
    // used to show Scene that you want to Move For .
    Parent root;

    public void gotToScene(Button btn, String fxmlFilePath) {
        try {
            root = FXMLLoader.load(getClass().getResource(fxmlFilePath));
        } catch (Exception e) {
            System.out.println("Error done with fxmlFilePath loader in CustomFunction !! ");
            System.out.println(e.getMessage());
        }
        Stage window = (Stage) btn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}
