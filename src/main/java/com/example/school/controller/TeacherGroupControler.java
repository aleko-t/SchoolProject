package com.example.school.controller;

import com.example.school.model.DTO.TeacherGroupDto;
import com.example.school.model.TeacherGroup;
import com.example.school.services.TeacherGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacherGroup")
public class TeacherGroupControler {
    @Autowired
    private TeacherGroupService teacherGroupService;

    @GetMapping
    public List<TeacherGroup> getTeacherGroup(){
        return teacherGroupService.getTeacherGroups();
    }
    @PostMapping("")
    public TeacherGroup addTeacherGroup(@RequestBody TeacherGroupDto teacherGroupDto  ){
        return teacherGroupService.addTeacherGroup(teacherGroupDto);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacherGroup(@PathVariable long id){
        teacherGroupService.deleteTeacherGroup(id);
    }


}
