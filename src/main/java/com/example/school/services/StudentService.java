package com.example.school.services;


import com.example.school.model.DTO.StudentDto;
import com.example.school.model.Group;
import com.example.school.model.Student;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.school.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupService groupService;

    public List<Student> getStudent() {
        return studentRepository.findAll();

    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElseThrow();
    }

    public Student getStudentByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName).orElseThrow();
    }

    public Student getStudentByLastName(String lastName){
        return studentRepository.findByLastName(lastName).orElseThrow();
    }

    public  Student getStudentByPersonNo(String personNo){
        return studentRepository.findByPersonNo(personNo).orElseThrow();
    }

    public Student getStudentByBirthDate(Date birthDate){
        return studentRepository.findByBirthDate(birthDate).orElseThrow();
    }

    public Student addStudent(StudentDto studentDto) {
        Group group = groupService.getGroupById(studentDto.getGroupId());

        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .personNo(studentDto.getPersonNo())
                .gmail(studentDto.getGmail())
                .birthDate(studentDto.getBirthDate())
                .group(group)
                .build();
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(long id, Student student) {
        Student oldStudent = studentRepository.findById(id).orElseThrow();
        student.setId(oldStudent.getId());
        return studentRepository.save(student);
    }

}

