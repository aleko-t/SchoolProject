package com.example.school.repository;

import com.example.school.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public  interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByFirstName(String firstName);
    Optional<Teacher> findByLastName(String lastName);
    Optional<Teacher> findByPersonNo(String personNo);
    Optional<Teacher> findByBirthDate(Date birthDate);
}
