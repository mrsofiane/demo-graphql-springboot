package me.mrsofiane.demographql.controllers;

import me.mrsofiane.demographql.entities.Student;
import me.mrsofiane.demographql.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("restapi")
public class RestApiController {

    private final StudentService studentService;

    public RestApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Map<String, String> restApi() {
        return Map.of("result","message from rest api");
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long studentId) {
        return studentService.getStudentById(studentId);
    }
}
