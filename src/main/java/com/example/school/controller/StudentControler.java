package com.example.school.controller;

import com.example.school.model.DTO.StudentDto;
import lombok.RequiredArgsConstructor;
import com.example.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.school.services.StudentService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentControler {
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<Student> getStudents(){
       return studentService.getStudent();
    }

   @GetMapping("/singleStudent")
   public Student getStudentByFirstName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) String personNo){
        
        return studentService.getStudentByFirstName(firstName);
   }

   @GetMapping("/lastName")
   public Student getStudentByLastName(@RequestParam String lastName){
        return studentService.getStudentByLastName(lastName);
   }
   @GetMapping("/personNO")
   public  Student getStudentByPersonNo(@RequestParam String personNo){
        return studentService.getStudentByPersonNo(personNo);
   }

   @GetMapping("/birthDate")
   public Student getStudentBybirthDate(@RequestParam Date birthDate){
        return studentService.getStudentByBirthDate(birthDate);
   }

    @PostMapping("")
    public Student addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent (@PathVariable long id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable long id){
        return studentService.updateStudent(id, student);
    }
}
