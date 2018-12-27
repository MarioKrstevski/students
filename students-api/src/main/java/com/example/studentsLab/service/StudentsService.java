package com.example.studentsLab.service;

import com.example.studentsLab.model.RawStudent;
import com.example.studentsLab.model.Student;
import com.example.studentsLab.model.exception.*;

import java.util.List;

public interface StudentsService {

    List<RawStudent> getAllStudents();

    List<Student> getByStudyProgramId(Long id) throws StudyProgram404Exception;

    Student getStudentByIndex(String index) throws Student404Exception;

    Student addStudent(RawStudent student) throws StudyProgram404Exception, Parameter404Exception, IndexFormatException, StudentExistsException;

    void deleteStudent(String index) throws Student404Exception;

    Student patchStudent(String index, RawStudent student) throws Student404Exception, StudyProgram404Exception;
}
