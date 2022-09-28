package com.web.spring.web.service.impl;

import com.web.spring.web.entity.Student;
import com.web.spring.web.repository.StudentRepository;
import com.web.spring.web.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        if (student.getId() == null){
            Student data = studentRepository.findByEmail(student.getEmail());
            if (data != null){
                if (data.getEmail().equalsIgnoreCase(student.getEmail())){
                    throw new ArithmeticException("email sudah ada");
                }
            }

        }

        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id).get();

        studentRepository.delete(student);
        return null;
    }
}
