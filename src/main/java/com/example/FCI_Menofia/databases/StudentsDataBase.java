package com.example.FCI_Menofia.databases;

import com.example.FCI_Menofia.student.StudentInfo;

import java.sql.*;

public class StudentsDataBase {
    static String user = "root"; // is the user that we tought before
    static String password = ""; // is the password that created for
    static String host = "jdbc:mysql://localhost/studentsdatabase"; // localhost/db_name
    static Connection connectionObj; // object to connect with the driver .

    public StudentsDataBase() {
        try {
            connectionObj = DriverManager.getConnection(host, user, password); // it always throw exception
            System.out.println("Connection with Students Database Done ## ");
            Statement stmt = connectionObj.createStatement();
            try {
                String studentTableCreationSqlCommnad = "CREATE TABLE STUDENTSDATABASE.STUDENTSINFO( " +
                        "NAME TEXT , " +
                        "LEVEL TEXT ," +
                        " DEPARTMENT TEXT," +
                        " SECTION TEXT ," +
                        " JPA DOUBLE ," +
                        " COURSE1 TEXT , " +
                        "COURSE2 TEXT ," +
                        " COURSE3 TEXT," +
                        " COURSE4 TEXT, " +
                        "COURSE5 TEXT, " +
                        "COURSE6 TEXT," +
                        " NATIONALID BIGINT," +
                        " CONSTRAINT PK1 PRIMARY KEY (NATIONALID)" +
                        " );";
                System.out.println(studentTableCreationSqlCommnad);
                stmt.execute(studentTableCreationSqlCommnad);

                System.out.println("com.example.FCI_Menofia.student table created successfully !!");
            } catch (Exception e) {
                System.out.println("error done while creating com.example.FCI_Menofia.student table");
            }
            connectionObj.close(); // close the connection with DB for security puproses .
            System.out.println("Connection colsed ##");
        } catch (Exception e) {
            System.out.println("There is an error while Connection with students database !!");
        }
    }

    /*
     *
     * insert com.example.FCI_Menofia.student into database
     *
     */
    public void insertNewStudentIntoStudentDataBase(StudentInfo studentObj) {
        try {
            connectionObj = DriverManager.getConnection(host, user, password);
            System.out.println("Connection with Students Database Done ## ");
            Statement stmt = connectionObj.createStatement();
            String insetStudentSqlCommand = "INSERT INTO studentsdatabase.studentsinfo " +
                    "VALUES( \"" + studentObj.studentName +
                    "\",\" " + studentObj.studentLevel +
                    "\",\" " + studentObj.studentDepartment +
                    "\",\"" + studentObj.studentSection +
                    "\"," + studentObj.studentJPA +
                    ",\" " + studentObj.studentCourse1 +
                    "\",\" " + studentObj.studentCourse2 +
                    "\",\" " + studentObj.studentCourse3 +
                    "\",\" " + studentObj.studentCourse4 +
                    "\",\" " + studentObj.studentCourse5 +
                    "\",\" " + studentObj.studentCourse6 +
                    "\",\" " + studentObj.nationalId +
                    "\");";
            System.out.println(insetStudentSqlCommand);
            stmt.execute(insetStudentSqlCommand);
        } catch (Exception e) {
            System.out.println("Error done while perform insert Student in database");
        }

    }
}
