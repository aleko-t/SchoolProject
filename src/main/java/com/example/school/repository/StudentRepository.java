package com.example.school.repository;

import com.example.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByFirstName(String firstName);
    Optional< Student> findByLastName(String lastName);
    Optional<Student> findByPersonNo(String personNo);
    Optional<Student> findByBirthDate(Date birthDate);

}
