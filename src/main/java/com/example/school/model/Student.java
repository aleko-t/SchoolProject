package com.example.school.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "student", schema = "school")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    @SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "person_no")
    private String personNo;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "birth_date")
    private Date birthDate;

    @ManyToOne()
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

//    @ManyToMany
//    @JoinTable(
//            name = "teachers_students",
//            joinColumns = {
//                    @JoinColumn(name = "student_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "teacher_id")
//            }
//    )
//    private List<Teacher> teachers;

}