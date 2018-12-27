package com.example.studentsLab.model;

import java.util.Objects;

public class RawStudentOutput {
    private String index;
    private String name;
    private String lastName;

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

    public RawStudentOutput(String index, String name, String lastName) {
        this.index = index;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawStudentOutput that = (RawStudentOutput) o;
        return Objects.equals(index, that.index) &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name, lastName);
    }
}
