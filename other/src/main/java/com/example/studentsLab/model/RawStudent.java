package com.example.studentsLab.model;

public class RawStudent {
    private String index;
    private String name;
    private String lastName;
    private String studyProgram;

    public void setIndex(String index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudyProgram() {
        return studyProgram;
    }
}
