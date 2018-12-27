package com.example.studentsLab;

import com.example.studentsLab.model.Student;
import com.example.studentsLab.service.StudentsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class StudentsLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsLabApplication.class, args);
	}

}
