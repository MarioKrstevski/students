package com.example.studentsLab.web;

import com.example.studentsLab.model.RawStudent;
import com.example.studentsLab.model.RawStudyProgram;
import com.example.studentsLab.model.Student;
import com.example.studentsLab.model.StudyProgram;
import com.example.studentsLab.model.exception.Student404Exception;
import com.example.studentsLab.model.exception.StudyProgram404Exception;
import com.example.studentsLab.model.exception.StudyProgramExistsException;
import com.example.studentsLab.service.StudyProgramServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
    @RequestMapping("/study_programs")
public class StudyProgramController {

    private StudyProgramServiceImplementation studyProgramServiceImplementation;

    @Autowired
    public StudyProgramController(StudyProgramServiceImplementation studyProgramServiceImplementation) {
        this.studyProgramServiceImplementation = studyProgramServiceImplementation;
       studyProgramServiceImplementation.addData();
    }

    @GetMapping
    public List<StudyProgram> getStudyPrograms() {

        return studyProgramServiceImplementation.getStudyPrograms();
    }

    @PostMapping
    public StudyProgram addStudyProgram(@RequestBody RawStudyProgram rawStudyProgram) throws StudyProgramExistsException {
        return studyProgramServiceImplementation.addStudyProgram(rawStudyProgram);
    }

    @DeleteMapping("/{index}")
    public void deleteStudyProgram(@PathVariable("index") Long index) throws StudyProgram404Exception {
        studyProgramServiceImplementation.deleteStudyProgram(index);
    }
    @PatchMapping("/{index}")
    public StudyProgram update(@PathVariable("index") Long id, @RequestBody RawStudyProgram rawStudyProgram) throws StudyProgram404Exception {
        return studyProgramServiceImplementation.patchStudyProgram(id, rawStudyProgram);
    }

}
