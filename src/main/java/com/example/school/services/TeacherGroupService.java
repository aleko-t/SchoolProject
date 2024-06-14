package com.example.school.services;

import com.example.school.model.DTO.TeacherGroupDto;
import com.example.school.model.Group;
import com.example.school.model.Teacher;
import com.example.school.model.TeacherGroup;
import com.example.school.repository.TeacherGroupRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherGroupService {
    @Autowired
    private TeacherGroupRepository teacherGroupRepository;
    @Autowired
    private  GroupService groupService;
    @Autowired
    private TeachersService teachersService;

    public List<TeacherGroup> getTeacherGroups(){
        return teacherGroupRepository.findAll();
    }
    public TeacherGroup addTeacherGroup(TeacherGroupDto teacherGroupDto ){
        Teacher teacher = teachersService.getTeacherById(teacherGroupDto.getTeacherId());
        Group group = groupService.getGroupById(teacherGroupDto.getGroupId());
        TeacherGroup teacherGroup = TeacherGroup.builder()
                .teacher(teacher)
                .group(group)
                .build();
        return teacherGroupRepository.save(teacherGroup);
    }
    public void deleteTeacherGroup(long id){
         teacherGroupRepository.deleteById(id);
    }
}
