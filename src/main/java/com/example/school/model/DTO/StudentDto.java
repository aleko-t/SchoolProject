package com.example.school.model.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    private String firstName;
    private String lastName;
    private String personNo;
    private String gmail;
    private Date birthDate;
    private Long groupId;
}