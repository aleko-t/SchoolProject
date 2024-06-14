package com.example.school.repository;


import com.example.school.model.TeacherGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherGroupRepository extends JpaRepository<TeacherGroup, Long> {
}
