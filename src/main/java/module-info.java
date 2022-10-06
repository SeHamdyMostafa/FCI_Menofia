module com.example.studentapp123456 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    exports com.example.FCI_Menofia;
    opens com.example.FCI_Menofia to javafx.fxml, javafx.controls, javafx.graphics;
    exports com.example.FCI_Menofia.student;
    exports com.example.FCI_Menofia.signUpAndLogin;
    opens com.example.FCI_Menofia.signUpAndLogin to javafx.controls, javafx.fxml, javafx.graphics;
    exports com.example.FCI_Menofia.CoursesScenesBackend;
    opens com.example.FCI_Menofia.CoursesScenesBackend to javafx.controls, javafx.fxml, javafx.graphics;
}