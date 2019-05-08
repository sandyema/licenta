package com.example.asus.studcardportabil;


import android.support.annotation.NonNull;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer studentId;
    private String studentNume;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNume() {
        return studentNume;
    }

    public void setStudentNume(String studentNume) {
        this.studentNume = studentNume;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getStudentFacultate() {
        return studentFacultate;
    }

    public void setStudentFacultate(String studentFacultate) {
        this.studentFacultate = studentFacultate;
    }

    public Integer getStudentAn() {
        return StudentAn;
    }

    public void setStudentAn(Integer studentAn) {
        StudentAn = studentAn;
    }

    public String getStudentPoza() {
        return studentPoza;
    }

    public void setStudentPoza(String studentPoza) {
        this.studentPoza = studentPoza;
    }

    public Student(String studentUsername, String studentPassword) {
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
    }

    private String studentUsername;
    private String studentPassword;
    private String studentFacultate;
    private Integer StudentAn;
    private String studentPoza;

    public Student() {
    }


    public Student(Integer studentId, String studentNume, String studentUsername, String studentPassword, String studentFacultate, Integer studentAn, String studentPoza) {
        this.studentId = studentId;
        this.studentNume = studentNume;
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
        this.studentFacultate = studentFacultate;
        StudentAn = studentAn;
        this.studentPoza = studentPoza;
    }

    public Student(String studentNume, String studentUsername, String studentPassword, String studentFacultate, Integer studentAn, String studentPoza) {
        this.studentNume = studentNume;
        this.studentUsername = studentUsername;
        this.studentPassword = studentPassword;
        this.studentFacultate = studentFacultate;
        StudentAn = studentAn;
        this.studentPoza = studentPoza;
    }
}
