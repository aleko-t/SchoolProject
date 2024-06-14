package com.example.school.controller;

import com.example.school.model.DTO.TeacherDto;
import com.example.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.school.services.TeachersService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeachersService teachersService;

    @GetMapping("")
    public List<Teacher> getTeachers(){
        return teachersService.getTeachers();
    }

    @GetMapping("/{id}")
    public  Teacher getTeacherById(@PathVariable Long id){
     return teachersService.getTeacherById(id);
    }

    @GetMapping("/firstName")
    public Teacher getTeacherByFirstName(@RequestParam String firstName){
        return teachersService.getTeacherByFirstName(firstName);
    }
    @GetMapping("/lastName")
    public Teacher getTeacherByLastName(@RequestParam String lastName){
        return teachersService.getTeacherByLastName(lastName);
    }

    @GetMapping("/personNo")
    public Teacher getTeacherByPersonNo(@RequestParam String personNO){
        return teachersService.getTeacherByPersonNo(personNO);
    }
    @GetMapping("/birthDate")
    public Teacher getTeacherByBirthDate(@RequestParam Date birthDate){
        return teachersService.getTeacherByBirthDate(birthDate);
    }


    @PostMapping("")
    private Teacher addTeacher(@RequestBody TeacherDto teacherDto ){
        return teachersService.addTeacher(teacherDto);
    }



    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable long id){
        teachersService.delete(id);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher ,@PathVariable long id){
        return teachersService.updateTeacher(id,teacher);
    }
}
