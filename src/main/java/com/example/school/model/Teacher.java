package com.example.school.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
//import com.example.school.model.TeacherGroup;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@JoinColumn

@Table(name = "teacher", schema = "school")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq_gen")
    @SequenceGenerator(name = "teacher_seq_gen", sequenceName = "teacher_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "person_no", unique = true)
    private String personNo;
    @Column(name = "gmail", unique = true)
    private String gmail;
    @Column(name = "birth_date")
    private Date birthDate;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

//    @ManyToMany(mappedBy = "teachers")
//    private List<Student> students;


}
