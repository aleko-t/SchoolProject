package com.example.school.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "student_group",schema = "school")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "studentGroup_seq_gen")
    @SequenceGenerator(name = "studentGroup_seq_gen", sequenceName = "studentGroup_sequence",allocationSize = 1)
    private long id;

    @OneToOne(targetEntity = Student.class)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;

    @OneToOne(targetEntity = Group.class)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;
}
