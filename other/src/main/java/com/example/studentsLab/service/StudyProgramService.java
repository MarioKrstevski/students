package com.example.studentsLab.service;

import com.example.studentsLab.model.RawStudyProgram;
import com.example.studentsLab.model.StudyProgram;
import com.example.studentsLab.model.exception.StudyProgram404Exception;
import com.example.studentsLab.model.exception.StudyProgramExistsException;

import java.util.List;

public interface StudyProgramService {

    List<StudyProgram> getStudyPrograms();
    StudyProgram addStudyProgram(RawStudyProgram rawStudyProgram) throws StudyProgramExistsException;
    void deleteStudyProgram(Long id) throws StudyProgram404Exception;

    StudyProgram patchStudyProgram(long id, RawStudyProgram newStudyProgram) throws StudyProgram404Exception;
}
