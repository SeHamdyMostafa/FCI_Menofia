package com.example.FCI_Menofia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.FCI_Menofia.student.StudentInfo;


public class InsertPage {
    public static StudentInfo student = new StudentInfo();
    @FXML
    private RadioButton BioRadioButton;

    @FXML
    private RadioButton CsRadioButton;

    @FXML
    private Button goToCoursesPage;

    @FXML
    private RadioButton IsRadioButton;

    @FXML
    private RadioButton ItRadioButton;

    @FXML
    private RadioButton OrRadioButton;

    @FXML
    private RadioButton OtherRadioButton;

    @FXML
    private RadioButton SeRadioButton;

    @FXML
    private Button goToMainPageButton;

    @FXML
    private TextField jpaTextField;

    @FXML
    private RadioButton level1RadioButton;

    @FXML
    private RadioButton level2RadioButton;

    @FXML
    private RadioButton level3RadioButton;

    @FXML
    private RadioButton level4RadioButton;

    @FXML
    private TextField nationalIdTextField;


    @FXML
    private TextField sectionTextField;

    @FXML
    private TextField studentNameTextField;
    // this boolean is used to see if all conditions is true while
    // inputting data in all textFields
    boolean allIsTrue = false;
    boolean nameIsTrue = false;
    boolean nationalIdIsTrue = false;
    boolean jpaIsTrue = false;
    boolean sectionIsTrue = false;
    public static int availableCoursesForStudent = 0;
    public static int coursesCounter = 0;
    public String studentName;
    String studentNationalId;
    /*
     *
     * Functions Section ->
     *
     */

    // this Function is called by courses page -
    // after choosing courses and then clicking done ..
    // the insertion query is sent to DB and GUI Back to insert Page
    // when you return . the all data and Controllers will be reseted .
    public void setInsertPageEmpty() {
        try {
            allIsTrue = false;
            nameIsTrue = false;
            nationalIdIsTrue = false;
            jpaIsTrue = false;
            sectionIsTrue = false;
            availableCoursesForStudent = 0;
            coursesCounter = 0;
            studentNameTextField.setText("");
            nationalIdTextField.setText("");
            jpaTextField.setText("");
            sectionTextField.setText("");
            level1RadioButton.setSelected(false);
            level2RadioButton.setSelected(false);
            level3RadioButton.setSelected(false);
            level4RadioButton.setSelected(false);
            CsRadioButton.setSelected(false);
            ItRadioButton.setSelected(false);
            IsRadioButton.setSelected(false);
            OrRadioButton.setSelected(false);
            SeRadioButton.setSelected(false);
            BioRadioButton.setSelected(false);
            OtherRadioButton.setSelected(false);
        } catch (Exception e) {
            System.out.println("error while make Insert Page empty");
        }
    }

    // Main Page Button Functionallity ->
    @FXML
    void goToMainPageFunction(ActionEvent event) {
        new CustomFunctions().gotToScene(goToMainPageButton, "mainPage.fxml");
    }

    // choosing the department is starting from level 3
    @FXML
    void level1RadioButtonSelected(ActionEvent event) {
        CsRadioButton.setDisable(true);
        ItRadioButton.setDisable(true);
        IsRadioButton.setDisable(true);
        OrRadioButton.setDisable(true);
    }

    @FXML
    void level2RadioButtonSelected(ActionEvent event) {
        CsRadioButton.setDisable(true);
        ItRadioButton.setDisable(true);
        IsRadioButton.setDisable(true);
        OrRadioButton.setDisable(true);
    }

    @FXML
    void level3RadioButtonSelected(ActionEvent event) {
        CsRadioButton.setDisable(false);
        ItRadioButton.setDisable(false);
        IsRadioButton.setDisable(false);
        OrRadioButton.setDisable(false);
    }

    @FXML
    void level4RadioButtonSelected(ActionEvent event) {
        CsRadioButton.setDisable(false);
        ItRadioButton.setDisable(false);
        IsRadioButton.setDisable(false);
        OrRadioButton.setDisable(false);
    }

    /*
     *
     * goToCoursesPage Button ("Next") ->
     *
     *
     */
    @FXML
    public void GoToCoursesPage() {
        /*
         *
         * StudentName Field checking
         *
         */
        // get Name of com.example.FCI_Menofia.student as String
        student.studentName = studentNameTextField.getText();
        if (studentNameTextField.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Name Input Error !");
            alert.setHeaderText("you can't leave name Field Empty !!");
            alert.setContentText("you must put Student name");
            alert.showAndWait();
        } else {
            if (student.studentName.length() < 10) {
                nameIsTrue = false;
                allIsTrue = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Name Input Error !");
                alert.setHeaderText("Error in Name Field");
                alert.setContentText("this is not invalid name !!");
                alert.showAndWait();
            } else {
                // convert String to chars to be able to compare it as integer values
                char[] nameInCahracters = student.studentName.toCharArray();
                // for each loop to compare
                for (int x : nameInCahracters) {
                    if ((x >= 65 && x <= 90) || (x >= 97 && x <= 122) || x == 32) { // if the item is char or white space
                        allIsTrue = true;
                        nameIsTrue = true;
                    } else {
                        nameIsTrue = false;
                        allIsTrue = false;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Name input Error !");
                        alert.setHeaderText("Error in Student Name Field");
                        alert.setContentText("Name Must be characters only !!");
                        alert.showAndWait();
                        break;
                    }
                }
            }
        }
        /*
         *
         * National id checking
         *
         */
        // get national id of com.example.FCI_Menofia.student
        student.nationalId = nationalIdTextField.getText();
        // check if the inputted National id is correct or not ->
        if (nationalIdTextField.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("National ID Input Error !");
            alert.setHeaderText("you can't leave National ID Field empty ");
            alert.setContentText("Student National id must be inserted !! ");
            alert.showAndWait();
        } else {
            if (student.nationalId.length() != 14) {
                nationalIdIsTrue = false;
                allIsTrue = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("National ID Input Error !");
                alert.setHeaderText("Error in National ID Field");
                alert.setContentText("National id can't be less than 14 Digit !! ");
                alert.showAndWait();
            } else {
                // convert the national id to Array of chars contains the Numbers
                char[] nationalIdInCahracters = student.nationalId.toCharArray();
                for (int x : nationalIdInCahracters) {
                    // if the item is digit then it pass .. else it mean that
                    // it char or special character etc .
                    if (x < 48 || x > 57) { // Numeric values from String to int
                        nationalIdIsTrue = false;
                        allIsTrue = false;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("National ID Input Error !");
                        alert.setHeaderText("Error in National ID Field");
                        alert.setContentText("National id Must be Numbers only !!");
                        alert.showAndWait();
                        break;
                    } else {
                        allIsTrue = true;
                        nationalIdIsTrue = true;
                    }
                }
                nationalIdIsTrue = true;
                allIsTrue = true;
            }
        }
        /*
         *
         * JPA checking ->
         *
         */
        try {
            // handling error that user put for example String and you wait for Double
            student.studentJPA = Double.parseDouble(jpaTextField.getText());
        } catch (Exception e) {
            jpaIsTrue = false;
            allIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("JPA Input Error !");
            alert.setHeaderText("Error in JPA Field");
            alert.setContentText("JPA Must be between 0 and 4 ");
            alert.showAndWait();

        } // see if the value that user put is larger than 4 or negative !!
        if (student.studentJPA < 0 || student.studentJPA > 4) {
            jpaIsTrue = false;
            allIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("JPA Input Error !");
            alert.setHeaderText("Error in JPA Field");
            alert.setContentText("JPA Must be between 0 and 4 ");
            alert.showAndWait();
        } else {
            // see the number of courses available for the Student #
            if (student.studentJPA < 1) availableCoursesForStudent = 4;
            else if (student.studentJPA < 2) availableCoursesForStudent = 5;
            else availableCoursesForStudent = 6;
            jpaIsTrue = true;
            allIsTrue = true;
        }
        /*
         *
         * Student Section ->
         *
         */
        // get Number of Section
        student.studentSection = sectionTextField.getText();
        if (sectionTextField.getText() == "") {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Section Input Error !");
            alert.setHeaderText("you can't leave Section Field Empty !!");
            alert.setContentText("Section Must be Numbers only !!");
            alert.showAndWait();
        } else {
            char[] studentSectionInChar = student.studentSection.toCharArray();
            for (int x : studentSectionInChar) {
                if (x < 48 || x > 57) {
                    sectionIsTrue = false;
                    allIsTrue = false;
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Section Input Error !");
                    alert.setHeaderText("Error in Section Field");
                    alert.setContentText("Section Must be Numbers only !!");
                    alert.showAndWait();
                    break;
                } else {
                    sectionIsTrue = true;
                    allIsTrue = true;
                }
            }
        }
        /*
         *
         * Student Level ->
         *
         */
        // getting the level of the com.example.FCI_Menofia.student
        if (level1RadioButton.isSelected()) {
            student.studentLevel = "Level 1";
        } else if (level2RadioButton.isSelected()) {
            student.studentLevel = "Level 2";
        } else if (level3RadioButton.isSelected()) {
            student.studentLevel = "Level 3";
        } else if (level4RadioButton.isSelected()) {
            student.studentLevel = "Level 4";
        }
        /*
         *
         * get Student Department ->
         *
         */
        // getting the department of the com.example.FCI_Menofia.student ->
        if (SeRadioButton.isSelected()) {
            student.studentDepartment = "SE";
        }
        if (CsRadioButton.isSelected()) {
            student.studentDepartment = "CS";
        }
        if (ItRadioButton.isSelected()) {
            student.studentDepartment = "IT";
        }
        if (IsRadioButton.isSelected()) {
            student.studentDepartment = "IS";
        }
        if (OrRadioButton.isSelected()) {
            student.studentDepartment = "OR";
        }
        if (BioRadioButton.isSelected()) {
            student.studentDepartment = "BIO";
        }
        if (OtherRadioButton.isSelected()) {
            student.studentDepartment = "other";
        }
        /*
         *
         * check if any one of input resources is empty " == null" ;
         * if there is some thing missing print error
         * else go to Courses page
         *
         */
        if (studentNameTextField.getText() == null ||
                nationalIdTextField.getText() == null ||
                sectionTextField.getText() == null ||
                jpaTextField.getText() == null ||
                student.studentLevel == null ||
                student.studentDepartment == null
        ) {
            allIsTrue = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error !");
            alert.setHeaderText("Error in One of Fields");
            alert.setContentText("you can't leave any one of Fields Empty !!");
            alert.showAndWait();
        } else {
            if (level3RadioButton.isSelected() && SeRadioButton.isSelected() && nameIsTrue == true && nationalIdIsTrue == true && jpaIsTrue == true && sectionIsTrue == true) {
                new CustomFunctions().gotToScene(goToCoursesPage, "SeLevel3Courses.fxml");
                System.out.println("com.example.FCI_Menofia.student obj in insert page -> " + student);
                System.out.println("Student name is -> " + student.studentName);
                System.out.println("Student National id is -> " + student.nationalId);
                System.out.println("Student JPA is -> " + student.studentJPA);
                System.out.println("Student Section is -> " + student.studentSection);
                System.out.println("Student level is -> " + student.studentLevel);
                System.out.println("Student department is -> " + student.studentDepartment);
                System.out.println("Number of Avilable Courses -> " + availableCoursesForStudent + "\n");
                System.out.println("Student that insert page mention for -> " + student);
                System.out.println();
                System.out.println();
            }
        }
    }
}
