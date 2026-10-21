package com.example.libraryproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.libraryproject.entity.Student;
import com.example.libraryproject.repository.StudentRepo;

@Service 
public class StudentService {

    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
        
    }
    //Get student by id
    public Student getStudentById(Long id){
        return studentRepo.findById(id)
        .orElseThrow(() -> 
        new RuntimeException("Student not found" + id)
    );
    }

    public Student saveStudent(Student student){
        return studentRepo.save(student);

    }
     public String updateStudentName(Long id,String name){
        Student student=studentRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found")); 
        student.setName(name);
        studentRepo.save(student);
        return student.getName();
      
     }
     public void deletestudet(Long id){
        if (!studentRepo.existsById(id)) {
            throw new RuntimeException("student not found with id:  "+id);
        }
        studentRepo.deleteById(id);
     }

     
}
