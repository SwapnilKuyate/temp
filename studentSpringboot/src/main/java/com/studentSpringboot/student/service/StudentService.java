package com.studentSpringboot.student.service;

import java.util.List;

import com.studentSpringboot.student.domain.Student;
import com.studentSpringboot.student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<Student> getAllStudents() {
        return repo.findAll();
    }
	
    public Student getStudentById(Long id) {
        return repo.findById(id).get();
    }
    
    public void saveStudent(Student student) {
         repo.save(student);
    }
    
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
    
     
    
    
}
