package com.example.school.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "group", schema = "school")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq_gen")
    @SequenceGenerator(name = "group_seq_gen", sequenceName = "group_seq", allocationSize = 1)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_num")
    private Integer groupNum;
//
//    @OneToMany()
//    @JoinColumn(name = "group_id")
//    private List<Teacher> teachers;
//
//    @OneToMany()
//    @JoinColumn(name = "group_id")
//    private List<Student> students;
}


//public class teacherGroup{
//    @ManyToOne()
//    @Column(name = "teacher_id")
//    private Long teacherId;
//}

//public class studentsGroup{
//    @ManyToOne()
//    @Column(name= "student_id")
//    private Long studentId;
//}