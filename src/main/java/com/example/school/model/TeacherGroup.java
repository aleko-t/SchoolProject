package com.example.school.model;

import com.example.school.model.Group;
import com.example.school.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "teacher_group", schema = "school")
public class TeacherGroup {
    @Id
    @GeneratedValue
    @SequenceGenerator(name = "teacherGroup_seq_gen",sequenceName = "teacherGroup_seq", allocationSize = 1)
    private Long id;
    //    @Column(name = "teacher_id")
    @ManyToOne(targetEntity = Teacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group  group;

}
