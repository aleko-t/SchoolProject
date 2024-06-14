package com.example.school.controller;
import com.example.school.model.DTO.StudentGroupDto;
import com.example.school.model.StudentGroup;
import com.example.school.services.StudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/studentGroup")
public class StudentGroupControler {
    @Autowired
    private StudentGroupService studentGroupService;

    @GetMapping("")
    public List<StudentGroup> getStudentGroups(){
        return studentGroupService.getStudentGroups();
    }

    @PostMapping("")
    public StudentGroup addStudentGroup(@RequestBody StudentGroupDto studentGroupDto){
        return studentGroupService.addStudentGroup(studentGroupDto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentGroup(@PathVariable long id){
        studentGroupService.deleteStudentGroup(id);
    }
}
