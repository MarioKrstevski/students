package com.example.studentsLab.persistence;

import com.example.studentsLab.model.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {
    public boolean existsByName(String name);

    public StudyProgram findByName(String name);
}
