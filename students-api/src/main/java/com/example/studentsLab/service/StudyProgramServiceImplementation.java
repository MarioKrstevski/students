package com.example.studentsLab.service;

import com.example.studentsLab.model.RawStudyProgram;

import com.example.studentsLab.model.StudyProgram;
import com.example.studentsLab.model.exception.StudyProgram404Exception;
import com.example.studentsLab.model.exception.StudyProgramExistsException;
import com.example.studentsLab.persistence.StudyProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramServiceImplementation implements StudyProgramService {

    @Autowired
    private StudyProgramRepository studyProgramRepo;

    @Override
    public List<StudyProgram> getStudyPrograms() {
        return studyProgramRepo.findAll();
    }

    public void addData()
    {
        StudyProgram studyProgram = new StudyProgram();
        studyProgram.setName("KNIA");

        StudyProgram studyProgram1 = new StudyProgram();
        studyProgram.setName("PET");
if(!studyProgramRepo.existsByName(studyProgram.getName()))
        studyProgramRepo.save(studyProgram);
        if(!studyProgramRepo.existsByName(studyProgram1.getName()))
        studyProgramRepo.save(studyProgram1);
    }

    @Override
    public StudyProgram addStudyProgram(RawStudyProgram rawStudyProgram) throws StudyProgramExistsException {
        if (studyProgramRepo.existsByName(rawStudyProgram.getName()))
            throw new StudyProgramExistsException();
        StudyProgram program = new StudyProgram();
        program.setName(rawStudyProgram.getName());
        studyProgramRepo.save(program);
        return program;
    }

    @Override
    public void deleteStudyProgram(Long id) throws StudyProgram404Exception {

        if (!studyProgramRepo.existsById(id))
            throw new StudyProgram404Exception();
        studyProgramRepo.deleteById(id);
    }

    @Override
    public StudyProgram patchStudyProgram(long id, RawStudyProgram newStudyProgram) throws StudyProgram404Exception {
        StudyProgram oldStudyProgram ;
        if(studyProgramRepo.existsById(id))
         oldStudyProgram = studyProgramRepo.findById(id).get();
        else throw  new StudyProgram404Exception();

        if (newStudyProgram.getName() != null) oldStudyProgram.setName(newStudyProgram.getName());

        studyProgramRepo.save(oldStudyProgram);

        return oldStudyProgram;


    }
}


