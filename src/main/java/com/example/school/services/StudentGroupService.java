package com.example.school.services;

import com.example.school.model.DTO.StudentGroupDto;
import com.example.school.model.Group;
import com.example.school.model.Student;
import com.example.school.model.StudentGroup;
import com.example.school.repository.StudentGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGroupService {
    @Autowired
    private StudentGroupRepository studentGroupRepository;
    @Autowired
    private StudentService studentService ;
    @Autowired
    private GroupService groupService;

    public List<StudentGroup> getStudentGroups(){
        return studentGroupRepository.findAll();
    }

    public StudentGroup getStudentGroupById(long id){
        return studentGroupRepository.findById(id).orElseThrow();
    }

    public  StudentGroup addStudentGroup(StudentGroupDto studentGroupDto){
        Student student = studentService.getStudentById(studentGroupDto.getStudentId());
        Group group = groupService.getGroupById(studentGroupDto.getGroupId());
        StudentGroup studentGroup = StudentGroup.builder()
                .student(student)
                .group(group)
                .build();
        return studentGroupRepository.save(studentGroup);
    }

    public void deleteStudentGroup(long id){
        studentGroupRepository.deleteById(id);
    }
}
