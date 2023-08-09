package ru.hogwarts.controllers;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.model.Student;
import ru.hogwarts.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping // READ / GET http://localhost:8080/faculty
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping // CREATE / POST http://localhost:8080/faculty
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    @GetMapping("/{id}") // READ / GET http://localhost:8080/faculty/23
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}") // UPDATE / PUT http://localhost:8080/faculty/23
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}") // DELETE http://localhost:8080/faculty/23
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
