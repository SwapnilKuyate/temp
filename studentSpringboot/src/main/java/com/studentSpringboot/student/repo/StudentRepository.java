package com.studentSpringboot.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentSpringboot.student.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
