package com.luv2code.controller;

import com.luv2code.entity.Student;
import com.luv2code.exception.StudentErrorResponse;
import com.luv2code.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> studentsDemo;
    @PostConstruct
    public void populateStudents(){
        studentsDemo = new ArrayList<>();
        Student student = new Student("Pepe", "Rodriguez");
        studentsDemo.add(student);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentsDemo;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentsDemo.size() <= studentId || studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return studentsDemo.get(studentId);
    }
}
