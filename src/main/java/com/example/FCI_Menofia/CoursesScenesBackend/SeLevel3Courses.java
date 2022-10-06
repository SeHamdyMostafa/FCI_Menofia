package com.example.FCI_Menofia.CoursesScenesBackend;

import com.example.FCI_Menofia.CustomFunctions;
import com.example.FCI_Menofia.InsertPage;
import com.example.FCI_Menofia.databases.StudentsDataBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class SeLevel3Courses extends InsertPage {

    String algorithmCheckBoxCurrentState = "unChecked";
    String aiCheckBoxCurrentState = "unChecked";
    String cloudComputingCheckBoxCurrentState = "unChecked";
    String programming3CheckBoxCurrentState = "unChecked";
    String se2CheckBoxCurrentState = "unChecked";
    String os2CheckBoxCurrentState = "unChecked";

    @FXML
    private Button insertStudentIntoDBButton;

    @FXML
    private CheckBox AlgorithmsCheckBox;

    @FXML
    private CheckBox artificialIntellegenceCheckBox;

    @FXML
    private CheckBox cloudComputingCheckBox;

    @FXML
    private CheckBox operatingSystem2CheckBox;

    @FXML
    private CheckBox programming3CheckBox;

    @FXML
    private CheckBox softwareEngineering2CheckBox;

    /*
     *
     * Algorithms CheckBox ->
     *
     */
    @FXML
    void AlgorithmsCheckBoxChecked(ActionEvent event) {
        if (super.availableCoursesForStudent > super.coursesCounter && algorithmCheckBoxCurrentState == "unChecked") {
            algorithmCheckBoxCurrentState = "checked";
            student.studentCourse1 = "Algorithms";
            super.coursesCounter++;
        } else if (algorithmCheckBoxCurrentState == "checked") {
            algorithmCheckBoxCurrentState = "unChecked";
            AlgorithmsCheckBox.setSelected(false);
            student.studentCourse1 = null;
            super.coursesCounter--;
        } else {
            System.out.println("Avilable Courses = " + super.availableCoursesForStudent + "and Choosen Courses = " + super.coursesCounter);
            AlgorithmsCheckBox.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choosing Courses Error !");
            alert.setHeaderText("Extra Courses added !!");
            alert.setContentText("you can't add More Courses for this com.example.FCI_Menofia.student Depending on his GPA");
            alert.showAndWait();
        }
    }

    /*
     *
     * AI CheckBox ->
     *
     *
     */
    @FXML
    void artificialIntellegenceCheckBoxChecked(ActionEvent event) {
        if (super.availableCoursesForStudent > super.coursesCounter && aiCheckBoxCurrentState == "unChecked") {
            aiCheckBoxCurrentState = "checked";
            student.studentCourse2 = "Artificail Intellegence";
            super.coursesCounter++;
        } else if (aiCheckBoxCurrentState == "checked") {
            algorithmCheckBoxCurrentState = "unChecked";
            AlgorithmsCheckBox.setSelected(false);
            student.studentCourse2 = null;
            super.coursesCounter--;
        } else {
            System.out.println("Avilable Courses = " + super.availableCoursesForStudent + "and Choosen Courses = " + super.coursesCounter);
            artificialIntellegenceCheckBox.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choosing Courses Error !");
            alert.setHeaderText("Extra Courses added !!");
            alert.setContentText("you can't add More Courses for this com.example.FCI_Menofia.student Depending on his GPA");
            alert.showAndWait();
        }
    }

    /*
     *
     * Cloud Computing CheckBox ->
     *
     */
    @FXML
    void cloudComputingCheckBoxChecked(ActionEvent event) {
        if (super.availableCoursesForStudent > super.coursesCounter && cloudComputingCheckBoxCurrentState == "unChecked") {
            cloudComputingCheckBoxCurrentState = "checked";
            student.studentCourse3 = "Cloud Computing";
            super.coursesCounter++;
        } else if (cloudComputingCheckBoxCurrentState == "checked") {
            cloudComputingCheckBoxCurrentState = "unChecked";
            cloudComputingCheckBox.setSelected(false);
            student.studentCourse3 = null;
            super.coursesCounter--;
        } else {
            System.out.println("Avilable Courses = " + super.availableCoursesForStudent + "and Choosen Courses = " + super.coursesCounter);
            cloudComputingCheckBox.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choosing Courses Error !");
            alert.setHeaderText("Extra Courses added !!");
            alert.setContentText("you can't add More Courses for this com.example.FCI_Menofia.student Depending on his GPA");
            alert.showAndWait();
        }
    }

    /*
     *
     * os2 CheckBox ->
     *
     */
    @FXML
    void operatingSystem2CheckBoxChecked(ActionEvent event) {
        if (super.availableCoursesForStudent > super.coursesCounter && os2CheckBoxCurrentState == "unChecked") {
            os2CheckBoxCurrentState = "checked";
            student.studentCourse4 = "Operating System2";
            super.coursesCounter++;
        } else if (os2CheckBoxCurrentState == "checked") {
            os2CheckBoxCurrentState = "unChecked";
            operatingSystem2CheckBox.setSelected(false);
            student.studentCourse4 = null;
            super.coursesCounter--;
        } else {
            System.out.println("Avilable Courses = " + super.availableCoursesForStudent + "and Choosen Courses = " + super.coursesCounter);
            operatingSystem2CheckBox.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choosing Courses Error !");
            alert.setHeaderText("Extra Courses added !!");
            alert.setContentText("you can't add More Courses for this com.example.FCI_Menofia.student Depending on his GPA");
            alert.showAndWait();
        }
    }

    /*
     *
     * programming 3 CheckBox ->
     *
     */
    @FXML
    void programming3CheckBoxChecked(ActionEvent event) {
        if (super.availableCoursesForStudent > super.coursesCounter && programming3CheckBoxCurrentState == "unChecked") {
            programming3CheckBoxCurrentState = "checked";
            student.studentCourse5 = "Programming 3";
            super.coursesCounter++;
        } else if (programming3CheckBoxCurrentState == "checked") {
            programming3CheckBoxCurrentState = "unChecked";
            programming3CheckBox.setSelected(false);
            student.studentCourse5 = null;
            super.coursesCounter--;
        } else {
            System.out.println("Avilable Courses = " + super.availableCoursesForStudent + "and Choosen Courses = " + super.coursesCounter);
            programming3CheckBox.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choosing Courses Error !");
            alert.setHeaderText("Extra Courses added !!");
            alert.setContentText("you can't add More Courses for this com.example.FCI_Menofia.student Depending on his GPA");
            alert.showAndWait();
        }
    }

    /*
     *
     *
     * SE-2 CheckBox ->
     *
     */
    @FXML
    void softwareEngineering2CheckBoxChecked(ActionEvent event) {
        if (super.availableCoursesForStudent > super.coursesCounter && se2CheckBoxCurrentState == "unChecked") {
            se2CheckBoxCurrentState = "checked";
            student.studentCourse6 = "Software Engineering 2";
            super.coursesCounter++;
        } else if (se2CheckBoxCurrentState == "checked") {
            se2CheckBoxCurrentState = "unChecked";
            softwareEngineering2CheckBox.setSelected(false);
            student.studentCourse6 = null;
            super.coursesCounter--;
        } else {
            System.out.println("Avilable Courses = " + super.availableCoursesForStudent + "and Choosen Courses = " + super.coursesCounter);
            softwareEngineering2CheckBox.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Choosing Courses Error !");
            alert.setHeaderText("Extra Courses added !!");
            alert.setContentText("you can't add More Courses for this com.example.FCI_Menofia.student Depending on his GPA");
            alert.showAndWait();
        }
    }

    @FXML
    void addStudentToDB(ActionEvent event) {
        System.out.println("Student that inesrt page mention for -> " + student);
        System.out.println("name -> " + student.studentName);
        System.out.println("national id -> " + student.nationalId);
        System.out.println("JPA -> " + student.studentJPA);
        System.out.println("Section -> " + student.studentSection);
        System.out.println("Level -> " + student.studentLevel);
        System.out.println("Department -> " + student.studentDepartment);
        System.out.println("course 1 -> " + student.studentCourse1);
        System.out.println("course 2 -> " + student.studentCourse2);
        System.out.println("course 3 -> " + student.studentCourse3);
        System.out.println("course 4 -> " + student.studentCourse4);
        System.out.println("course 5 -> " + student.studentCourse5);
        System.out.println("course 6 -> " + student.studentCourse6);
        try {
            // displayStudentInfo();
            new StudentsDataBase().insertNewStudentIntoStudentDataBase(student);
            System.out.println("inserting com.example.FCI_Menofia.student in database done successfully ##");
        } catch (Exception e) {
            System.out.println("Error while insertring com.example.FCI_Menofia.student inside the database");
        }
        try {
            new CustomFunctions().gotToScene(insertStudentIntoDBButton, "insertPage.fxml");
        } catch (Exception e) {
            System.out.println("Error when moving from Courses page to insert Page !! ");
        } finally {
            student.studentName = null;
            student.studentLevel = null;
            student.studentDepartment = null;
            student.studentJPA = 0.0;
            student.studentSection = null;
            student.studentCourse1 = null;
            student.studentCourse2 = null;
            student.studentCourse3 = null;
            student.studentCourse4 = null;
            student.studentCourse5 = null;
            student.studentCourse6 = null;
            super.setInsertPageEmpty();
        }

    }

}
