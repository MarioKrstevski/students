package com.example.studentsLab.web;

import com.example.studentsLab.model.RawStudent;
import com.example.studentsLab.model.RawStudentOutput;
import com.example.studentsLab.model.Student;
import com.example.studentsLab.model.exception.*;
import com.example.studentsLab.service.StudentServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/students",produces = {"application/json"})
public class StudentController {

    private final StudentServiceImplementation studentServiceImplementation;

    @Autowired
    public StudentController(StudentServiceImplementation studentServiceImplementation) {
        this.studentServiceImplementation = studentServiceImplementation;
        studentServiceImplementation.addData();
    }

    @GetMapping
    public List<RawStudent> getStudents() {

        return studentServiceImplementation.getAllStudents();
    }

    @GetMapping("/{index}")
    public Student getStudentByIndex(@PathVariable("index") String index, HttpServletResponse response) throws Student404Exception {
        return studentServiceImplementation.getStudentByIndex(index);

    }

    @GetMapping("/by_study_program/{id}")
    public List<Student> getByStudyProgramId(@PathVariable("id") Long id) throws StudyProgram404Exception {

        return studentServiceImplementation.getByStudyProgramId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody RawStudent rawStudent, HttpServletResponse response) throws StudentExistsException, IndexFormatException, Parameter404Exception, StudyProgram404Exception {

    Student student=    studentServiceImplementation.addStudent(rawStudent);

      /* if(student!=null) {
           try {
               response.sendRedirect(String.format("/students/%s", student.getIndex()));
           } catch (IOException e) {
               e.printStackTrace();
           }
       }*/



    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable String index) throws Student404Exception {
        studentServiceImplementation.deleteStudent(index);
    }

    @PatchMapping("/{index}")
    public Student update(@PathVariable String index, @RequestBody RawStudent rawStudent) throws Student404Exception, StudyProgram404Exception {
       return studentServiceImplementation.patchStudent(index, rawStudent);
    }


}
