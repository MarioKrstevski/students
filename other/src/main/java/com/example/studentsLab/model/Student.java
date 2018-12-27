package com.example.studentsLab.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student")

public class Student implements Serializable {
    @Id
    @Column(nullable = false)
    private String index;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")

    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)

    private StudyProgram studyProgram;

    public Student() {
        super();
    }

    public Student(String index, String name, String lastName, StudyProgram studyProgram) {
        this.index = index;
        this.name = name;
        this.lastName = lastName;
        this.studyProgram = studyProgram;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(index, student.index) &&
                Objects.equals(name, student.name) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(studyProgram, student.studyProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name, lastName, studyProgram);
    }

    @Override
    public String toString() {
        return "Student{" +
                "index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyProgram=" + studyProgram +
                '}';
    }
}
