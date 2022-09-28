package com.web.spring.web.controller;

import com.web.spring.web.entity.Student;
import com.web.spring.web.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllStudent(Model model){
        model.addAttribute("students", studentService.getAll());
        return "students";
    }

    @GetMapping("/students/new")
    public String addStudentsForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_students";
    }

    @PostMapping("/students")
    public String saveStudents(@ModelAttribute("student") Student student, RedirectAttributes redirAttrs){
        try {
            studentService.saveStudent(student);
            redirAttrs.addFlashAttribute("success", "data berhasil di tambahkan");
            return "redirect:/students";
        }catch (Exception d){
            redirAttrs.addFlashAttribute("error", d.getMessage());
            return "redirect:/students";
        }

    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.findById(id).get());
        return "edit_students";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute ("student") Student student, Model model){
        Student existingData = studentService.findById(id).get();
        existingData.setId(id);
        existingData.setFirstName(student.getFirstName());
        existingData.setLastName(student.getLastName());
        existingData.setEmail(student.getEmail());

        studentService.saveStudent(existingData);

        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String delteStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.deleteStudent(id));
        return "redirect:/students";
    }
}
