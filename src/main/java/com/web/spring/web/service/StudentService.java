package com.web.spring.web.service;

import com.web.spring.web.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAll();
    Student saveStudent(Student student);
    Optional<Student> findById (Long id);
    Student deleteStudent(Long id);
}
