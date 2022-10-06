package com.example.FCI_Menofia;

import com.example.FCI_Menofia.databases.StudentsDataBase;
import com.example.FCI_Menofia.signUpAndLogin.LoginDatabase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SignUpPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Insert New Student..");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error while starting the app in FX");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}