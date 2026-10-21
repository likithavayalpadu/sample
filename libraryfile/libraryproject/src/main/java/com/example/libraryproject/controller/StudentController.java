package com.example.libraryproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryproject.entity.Student;
import com.example.libraryproject.service.StudentService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping ("/student")
public class StudentController {
    
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student savestudent(@RequestBody Student student){
        return studentService.saveStudent(student);

    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/getstd/{id}") 
    public ResponseEntity<Student> getStudentByid(@PathVariable Long id ){
        //Student student = studentService.getStudentById(id);
        //return ResponseEntity.ok(student);
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(studentService.getStudentById(id));
    }
    @PutMapping("/{id}/name")
    public String updateStudentName(@PathVariable Long id,@RequestParam String name){
        return studentService.updateStudentName(id, name);
    }   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletestudent(@PathVariable  Long id){
        studentService.deletestudet(id);
        return ResponseEntity.noContent().build();
    }


    
    }

    

