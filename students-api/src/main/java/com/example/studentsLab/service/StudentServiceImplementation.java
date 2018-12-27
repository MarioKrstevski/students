package com.example.studentsLab.service;

import com.example.studentsLab.model.RawStudent;
import com.example.studentsLab.model.RawStudentOutput;
import com.example.studentsLab.model.Student;
import com.example.studentsLab.model.StudyProgram;
import com.example.studentsLab.model.exception.*;
import com.example.studentsLab.persistence.StudentRepository;
import com.example.studentsLab.persistence.StudyProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentsService {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private StudyProgramRepository studyProgramRepo;

    public StudentServiceImplementation() {

    }

    public void addData() {
        StudyProgram studyProgram = new StudyProgram();
        studyProgram.setName("KNIA");
        Student student = new Student();
        student.setName("Gjorgjina");
        student.setIndex("161517");
        student.setLastName("Cenikj");
        student.setStudyProgram(studyProgram);

        studyProgramRepo.save(studyProgram);
        if (!studentRepo.existsById(student.getIndex()))
            studentRepo.save(student);

        StudyProgram studyProgram1 = new StudyProgram();
        studyProgram.setName("PET");
        Student student1 = new Student();
        student1.setStudyProgram(studyProgram1);
        student1.setLastName("Popeska");
        student1.setIndex("151214");
        student1.setName("Marija");

        studyProgramRepo.save(studyProgram1);
        if (!studentRepo.existsById(student1.getIndex()))
            studentRepo.save(student1);

        Student student2 = new Student();
        student2.setName("Nikola");
        student2.setLastName("Nikolovski");
        student2.setStudyProgram(studyProgram);
        student2.setIndex("151613");
        if (!studentRepo.existsById(student2.getIndex()))
            studentRepo.save(student2);

    }

    @Override
    public List<RawStudent> getAllStudents() {
List<RawStudentOutput> raws = (List<RawStudentOutput>) studentRepo.findAllBy(RawStudentOutput.class);
    return raws.stream().map(x-> convert(x)).collect(Collectors.toList());
    }

    public RawStudent convert (RawStudentOutput x)
    {
        RawStudent r = new RawStudent();
        r.setName(x.getName());
        r.setLastName(x.getLastName());
        r.setIndex(x.getIndex());
        r.setStudyProgram(studentRepo.findById(x.getIndex()).get().getStudyProgram().getName());
        return  r;
    }


    @Override
    public List<Student> getByStudyProgramId(Long id) throws StudyProgram404Exception {

        if (!studyProgramRepo.existsById(id)) throw new StudyProgram404Exception();
        return studentRepo.findByStudyProgram(studyProgramRepo.findById(id).get());
    }

    @Override
    public Student getStudentByIndex(String index) throws Student404Exception {

        if (!studentRepo.existsById(index)) throw new Student404Exception(index);
        return studentRepo.findById(index).get();
    }

    public Student convertToStudent(RawStudent student) throws StudyProgram404Exception, Parameter404Exception, IndexFormatException {
        if (student.getName() == null) throw new Parameter404Exception("Name");
        if (student.getLastName() == null) throw new Parameter404Exception("Last name");
        if (student.getStudyProgram() == null) throw new Parameter404Exception("Study program name");
        if (student.getIndex() == null) throw new Parameter404Exception("Index");
        if (student.getIndex().length() != 6) throw new IndexFormatException(student.getIndex());


        Student student1 = new Student(student.getIndex(), student.getName(), student.getLastName(), studyProgramRepo.findByName(student.getStudyProgram()));
       /* student1.setIndex(student.getIndex());
        student1.setStudyProgram(studyProgramRepo.findByName(student.getStudyProgramName()));
        student1.setLastName(student.getLastName());
        student1.setName(student.getName());*/
        return student1;
    }

    @Override
    public Student addStudent(RawStudent student) throws StudyProgram404Exception, Parameter404Exception, IndexFormatException, StudentExistsException {

        if (!studyProgramRepo.existsByName(student.getStudyProgram())) {
            throw new StudyProgram404Exception();
        }
        if (studentRepo.findById(student.getIndex()).isPresent()) {
            throw new StudentExistsException(student.getIndex());
        }

        Student convertedStudent = convertToStudent(student);
        studentRepo.save(convertedStudent);
        return convertedStudent;


    }

    @Override
    public void deleteStudent(String index) throws Student404Exception {

        if (!studentRepo.existsById(index)) throw new Student404Exception(index);
        studentRepo.deleteById(index);

    }

    @Override
    public Student patchStudent(String index, RawStudent newStudent) throws Student404Exception, StudyProgram404Exception {

        if (!studentRepo.existsById(index))
            throw new Student404Exception(index);
        Student oldStudent = studentRepo.findById(index).get();
        if (newStudent.getName() != null) oldStudent.setName(newStudent.getName());
        if (newStudent.getLastName() != null) oldStudent.setLastName(newStudent.getLastName());
        if (newStudent.getStudyProgram() != null) {
            if (!studyProgramRepo.existsByName(newStudent.getStudyProgram()))
                throw new StudyProgram404Exception();
            oldStudent.setStudyProgram(
                    studyProgramRepo.findByName(newStudent.getStudyProgram())
            );
        }
        // studentRepo.deleteById(index);
        studentRepo.save(oldStudent);

        return oldStudent;


    }
}
