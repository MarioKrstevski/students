package com.example.studentsLab.persistence;

import com.example.studentsLab.model.Student;
import com.example.studentsLab.model.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<Student, String> {

   <T>Collection<T> findAllBy(Class<T> type);

  List<Student> findByStudyProgram(StudyProgram studyProgram);

}


