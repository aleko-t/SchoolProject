package com.example.school.services;

import com.example.school.model.DTO.TeacherDto;
import com.example.school.model.Group;
import com.example.school.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.school.repository.TeacherRepository;

import java.util.Date;
import java.util.List;


@Service
public class TeachersService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private GroupService groupService;

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public  Teacher getTeacherById(long id){
        return teacherRepository.findById(id).orElseThrow();
    }

    public Teacher getTeacherByFirstName(String firstName){
        return teacherRepository.findByFirstName(firstName).orElseThrow();
    }

    public Teacher getTeacherByLastName(String lastName){
        return teacherRepository.findByLastName(lastName).orElseThrow();
    }

    public  Teacher getTeacherByPersonNo(String personNO){
        return  teacherRepository.findByPersonNo(personNO).orElseThrow();
    }
    public  Teacher getTeacherByBirthDate(Date birtDate){
        return teacherRepository.findByBirthDate(birtDate).orElseThrow();
    }
    public Teacher addTeacher(TeacherDto teacherDto){
        Group group = groupService.getGroupById(teacherDto.getGroupId());

        Teacher teacher = Teacher.builder()
                .firstName(teacherDto.getFirstName())
                .lastName(teacherDto.getLastName())
                .personNo(teacherDto.getPersonNo())
                .gmail(teacherDto.getGmail())
                .birthDate(teacherDto.getBirthDate())
                .group(group)
                .build();

        return teacherRepository.save(teacher);
    }

    public void  delete(long id){
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(long id, Teacher teacher ) {
        Teacher oldTeacher = teacherRepository.findById(id).orElseThrow();
        teacher.setId(oldTeacher.getId());
        return teacherRepository.save(teacher);
    }
}
