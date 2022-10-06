package com.example.FCI_Menofia;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class modeltabel {
    String name, level, department, section, jpa, course1, course2, course3, course4, course5, course6, nationalid;

    public modeltabel() {

    }

    public modeltabel(String name, String level, String department, String section, String jpa, String course1, String course2, String course3, String course4, String course5, String course6, String nationalid) {
        this.name = name;
        this.level = level;
        this.department = department;
        this.section = section;
        this.jpa = jpa;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.course4 = course4;
        this.course5 = course5;
        this.course6 = course6;
        this.nationalid = nationalid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setDepartment(String dpa) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public void setJpa(String jpa) {
        this.jpa = jpa;
    }

    public String getJpa() {
        return jpa;
    }

    public void setCourse1(String course1) {
        this.course1 = course1;
    }

    public String getCourse1() {
        return course1;
    }

    public void setCourse2(String course2) {
        this.course2 = course2;
    }

    public String getCourse2() {
        return course2;
    }

    public void setCourse3(String course3) {
        this.course3 = course3;
    }

    public String getCourse3() {
        return course3;
    }

    public void setCourse4(String course4) {
        this.course4 = course4;
    }

    public String getCourse4() {
        return course4;
    }

    public void setCourse5(String course5) {
        this.course5 = course5;
    }

    public String getCourse5() {
        return course5;
    }

    public void setCourse6(String course6) {
        this.course6 = course6;
    }

    public String getCourse6() {
        return course6;
    }

    public void setNationalid(String nationalid) {
        this.nationalid = nationalid;
    }

    public String getNationalid() {
        return nationalid;
    }


}
